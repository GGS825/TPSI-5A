<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="it.molinari.model.Prodotto" %>
<%@ page import="java.util.List" %>

<link rel="stylesheet" type="text/css" href="Style_welcome.css">
<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	</head>
<body background="https://static.vecteezy.com/ti/vettori-gratis/p1/5021299-sfondo-azzurro-e-un-motivo-questo-sfondo-e-adatto-per-sfondi-cellulari-sfondi-di-presentazione-e-altro-gratuito-vettoriale.jpg" >
		<div id="header">
		<h1>Benvenuto Modalità Cliente</h1>
		</div>
	
		<!-- Container per Menu e CorpoPrincipale -->
		<div id="mainContainer" >
	
			<!-- Menu -->
			<div id="modello">
				<div id="select">
					<form action="ProdottoServlet" method="get">
						<label>Visualizza Elenco</label>
						<input type="hidden" name="azione" value="selectc"><br>
						<input type="submit" value="Invio">
				    </form>
				</div>
				
				<div id="update">
					<form action="ProdottoServlet" method="get">
						<label>Acquista</label><br>
						<input type="hidden" name="azione" value="acquistac">
						<label>Indice:</label>
						<input type="number" name="id" min=1 >
						<label>Quantita:</label>
						<input type="text" name="quantita"><br>
						<input type="submit" value="Invio"><br>
					</form>
				</div>
		</div>
			<!-- CorpoPrincipale -->
			<div>
				<table  border="1" >
			<%
			    String messaggio =(String) request.getAttribute("messaggio");
			    out.println(messaggio);
			
			
				List<Prodotto> utenti = (List<Prodotto>) request.getAttribute("cliente");
		 		if (utenti != null)
		 		{
		 			out.println("<tr>" + "<th>" +"ID" +"</th>"+ "<th>" +"Elenco" +"</th>" +  "<th>" +"Quantita" +"</th>" + "<th>" +"Prezzo" +"</th>"+"</tr>");
					        for (Prodotto u : utenti) 
					 {
					    out.println("<tr>" + "<td>" +u.getId() + "<td>" +u.getNome()+ "<td>" +u.getQuantita() + "<td>" +u.getPrezzo()+"</td>"+"</td>"+"</td>"+"</td>" + "</tr>");
					 }
		   		}
		 		else
		 		{
		        out.println("<p>Null</p>");
		   	    }
	   		 %>
	   			</table>
			</div>
	
		</div>
		
			<div id="footer">
				<h1>Footer</h1>
			</div>
	</body>l>