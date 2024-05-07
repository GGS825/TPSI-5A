package it.molinari.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import it.molinari.model.Prodotto;
import it.molinari.model.UtenteDTO;
import it.molinari.service.UtenteService;

/**
 * Servlet implementation class ProdottoServlet
 */
public class ProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdottoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        String azione =request.getParameter("azione");
		
		
		switch (azione) {
        case "selectm":
        	UtenteService us1=new UtenteService();
        	List<Prodotto> u1=us1.maz_getLista();
        	
        	request.setAttribute("utente1",u1);
			request.getRequestDispatcher("/welcome_magazziniere.jsp").forward(request, response);
            break;
        case "insertm":
        	UtenteService us2=new UtenteService();
        	String nome =request.getParameter("nome");
        	String quantita =request.getParameter("quantita");
        	String prezzo =request.getParameter("prezzo");
        	if(us2.maz_insert(nome,quantita,prezzo))
        	{
        		response.getWriter().append("insert successo");
        	}
        	else
        	{
        		response.getWriter().append("insert fallita");
        	}
        	break;
        case "deletem":
        	UtenteService us3=new UtenteService();
        	
        	String ids = request.getParameter("id");
        	if(us3.maz_delete(ids)==true)
        	{
        		response.getWriter().append("cancella successo");
        	}
        	else
        	{
        		response.getWriter().append("cancella fallita");
        	}
        	
            break;
        case "updatem":
        	UtenteService us4=new UtenteService();
        	
        	String id1 = request.getParameter("id");
        	String quantita1 =request.getParameter("quantita");
        	
        	if(us4.maz_update(id1,quantita1)==true)
        	{
        		response.getWriter().append("update successo");
        	}
        	else
        	{
        		response.getWriter().append("update fallita");
        	}
        	
        	break;
        case "selectc":
        	UtenteService us5=new UtenteService();
        	List<Prodotto> u11=us5.u_getLista();
        	
        	request.setAttribute("cliente",u11);
			request.getRequestDispatcher("/welcome_cliente.jsp").forward(request, response);
            break;
        case "acquistac":
        	String id2 = request.getParameter("id");
        	String q = request.getParameter("quantita");
        	UtenteService us6=new UtenteService();
        	if(us6.u_acquista(id2,q)==true)
        	{
                us5=new UtenteService();
            	u11=us5.u_getLista();
            	
            	request.setAttribute("cliente",u11);
        		request.setAttribute("messaggio", "Acquista Successa");
        		request.getRequestDispatcher("/welcome_cliente.jsp").forward(request, response);
        	}
        	else
        	{
        		response.getWriter().append("Acquista fallita");
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
