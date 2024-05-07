package it.molinari.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import it.molinari.model.*;
import it.molinari.service.*;

/**
 * Servlet implementation class UtenteServlet
 */
public class UtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UtenteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String azione = (String) request.getParameter("azione");
		
		
		switch (azione) {
        case "selecta":
        	UtenteService us1=new UtenteService();
        	List<UtenteDTO> u=us1.adm_getLista();
        	
        	request.setAttribute("utente1",u);
			request.getRequestDispatcher("/welcome_adm.jsp").forward(request, response);
            break;
        case "update":
        	UtenteService us2=new UtenteService();
        	
        	String ruolo =request.getParameter("ruolo");
        	String id1 = request.getParameter("id");
        	if(us2.adm_update(ruolo,id1)==true)
        	{
        		response.getWriter().append("update successo");
        	}
        	else
        	{
        		response.getWriter().append("update fallita");
        	}
        	
        	break;
        case "insert":
        	UtenteService us3=new UtenteService();
        	String u1 =request.getParameter("utente");
        	String p =request.getParameter("password");
        	if(us3.adm_insert(u1,p)==true)
        	{
        		response.getWriter().append("insert successo");
        	}
        	else
        	{
        		response.getWriter().append("insert fallita");
        	}
        	break;
        case "delete":
        	UtenteService us4=new UtenteService();
        	
        	String id2 = request.getParameter("id");
        	if(us4.adm_delete(id2)==true)
        	{
        		response.getWriter().append("cancella successo");
        	}
        	else
        	{
        		response.getWriter().append("cancella fallita");
        	}
        	
            break;
        default:
            System.out.println("Azione non riconosciuta.");
            break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
