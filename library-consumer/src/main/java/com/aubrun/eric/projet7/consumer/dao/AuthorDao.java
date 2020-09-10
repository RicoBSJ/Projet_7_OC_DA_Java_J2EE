package com.aubrun.eric.projet7.consumer.dao;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.beans.SearchModel;
import com.aubrun.eric.projet7.consumer.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorDao {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Author> recupererAuteurs() {

        Session session = factory.openSession();
        List<Author> authors = null;

        try {
            String q = "SELECT b FROM Author b";
            Query<Author> query = session.createQuery( q );
            authors = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return authors;
    }

    public Author afficherParId( Integer id ) {

        Session session = factory.openSession();
        Author author = null;

        try {
            String q = "SELECT a FROM Author a WHERE a.id=?1";
            TypedQuery<Author> query = session.createQuery( q, Author.class );
            query.setParameter( 1, id );
            author = query.getSingleResult();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return author;
    }

    public Author supprimerAuteur(Integer id ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            Author author = session.get( Author.class, id );
            if ( author != null ) {
                String q = "DELETE FROM Author b " + "WHERE b.id = :authorId";
                Query<Author> query = session.createQuery( q );
                query.setParameter( "authorId", id );
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

    public void ajouterAuteur( Author author ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( author );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public List<Author> recherche( SearchModel searchForm ) {
        Session session = factory.openSession();
        List<Author> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            String q = "SELECT a FROM Author a WHERE 1=1 ";
            if ( searchForm.getTitle() != "" ) {
                q += "AND a.title LIKE :title ";
                parameters.put( "title", "%" + searchForm.getTitle() + "%" );
            }
            if ( searchForm.getCategory() != "" ) {
                q += "AND a.category LIKE :category ";
                parameters.put( "category", "%" + searchForm.getCategory() + "%" );
            }
            Query<Author> query = session.createQuery( q );
            query.setProperties( parameters );
            resultat = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return resultat;
    }

    public void modifierAuteur( Author author ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.saveOrUpdate( author );
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
