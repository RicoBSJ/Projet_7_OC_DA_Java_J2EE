package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.beans.Book;
import com.aubrun.eric.projet7.beans.SearchModel;
import com.aubrun.eric.projet7.business.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RechercheLivre extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_SITES        = "sites";
    public static final String VUE              = "/WEB-INF/view/rechercheSite.jsp";
    public static final String VUE_RESULT       = "/WEB-INF/view/accueil.jsp";

    private BookService bookService             = new BookService();

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        SearchModel searchBook = new SearchModel();
        searchBook.setTitle( request.getParameter( "title" ) );
        searchBook.setCategory( request.getParameter( "category" ) );
        searchBook.setQuantity(Integer.valueOf(request.getParameter( "quantity" )));
        searchBook.setRenewalLoan(Boolean.valueOf(request.getParameter( "renewalLoan" )));
        searchBook.setQuantityLoan(Integer.valueOf(request.getParameter( "quantityLoan" )));

        List<Book> bookList = bookService.searchBook(searchBook);

        request.setAttribute( ATT_SITES, bookList );

        this.getServletContext().getRequestDispatcher( VUE_RESULT ).forward( request, response );
    }
}
