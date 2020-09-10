package com.aubrun.eric.projet7.consumer.dao;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.SearchModel;
import com.aubrun.eric.projet7.consumer.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDao {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Book> recupererLivres() {

        Session session = factory.openSession();
        List<Book> books = null;

        try {
            String q = "SELECT b FROM Book b";
            Query<Book> query = session.createQuery( q );
            books = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return books;
    }

    public Book afficherParId( Integer id ) {

        Session session = factory.openSession();
        Book book = null;

        try {
            String q = "SELECT b FROM Book b WHERE b.id=?1";
            TypedQuery<Book> query = session.createQuery( q, Book.class );
            query.setParameter( 1, id );
            book = query.getSingleResult();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return book;
    }

    public Book supprimerLivre(Integer id ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            Book book = session.get( Book.class, id );
            if ( book != null ) {
                String q = "DELETE FROM Book b " + "WHERE b.id = :bookId";
                Query<Book> query = session.createQuery( q );
                query.setParameter( "bookId", id );
                int result = query.executeUpdate();
                System.out.println( result );
            }

            session.getTransaction().commit();
        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public void ajouterLivre( Book book ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( book );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public List<Book> recherche( SearchModel searchForm ) {
        Session session = factory.openSession();
        List<Book> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            String q = "SELECT b FROM Book b WHERE 1=1 ";
            if ( searchForm.getTitle() != "" ) {
                q += "AND b.title LIKE :title ";
                parameters.put( "title", "%" + searchForm.getTitle() + "%" );
            }
            if ( searchForm.getCategory() != "" ) {
                q += "AND b.category LIKE :category ";
                parameters.put( "category", "%" + searchForm.getCategory() + "%" );
            }
            Query<Book> query = session.createQuery( q );
            query.setProperties( parameters );
            resultat = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return resultat;
    }

    public void modifierLivre( Book book ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.saveOrUpdate( book );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}