package it.molinari.controller;
import it.molinari.model.*;
import it.molinari.service.UtenteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String login = (String) request.getParameter("login");
		String registra = (String) request.getParameter("registra");
	
		if(login!=null)
		{
			Verifica v=new Verifica();
			String risultato=v.accesso(username,password);
			
			if(v.getAccesso()==true)
			{
				if (risultato.equals("adm"))
				{
					
					request.getRequestDispatcher("/welcome_adm.jsp").forward(request,response);

				}
				else if(risultato.equals("utent"))
				{
					request.getRequestDispatcher("/welcome_utente.jsp").forward(request,response);
					
				}
				else if(risultato.equals("clien"))
				{
					
					request.getRequestDispatcher("/welcome_cliente.jsp").forward(request,response);
					
				}
				else if(risultato.equals("magaz"))
				{
					
					request.getRequestDispatcher("/welcome_magazziniere.jsp").forward(request,response);
					
				}
				else
				{
					response.getWriter().append("valuta error");
				}
			}
			else
			{
				
				request.getRequestDispatcher("/Errore_login.html").forward(request,response);	
			}
		}
		else if(registra!=null)
		{
			UtenteService u=new UtenteService();
			if(u.adm_insert_u(username,password)==true)
        	{
				request.getRequestDispatcher("/Registra_successa.html").forward(request,response);
        	}
        	else
        	{
        		request.getRequestDispatcher("/Registra_fallita.html").forward(request,response);
        	}
		}
		else 
		{
			response.getWriter().append("errore sconosciuto");
		}
		
		
		
	}

}
