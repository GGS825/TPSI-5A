<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="it.molinari.model.Prodotto" %>
<%@ page import="java.util.List" %>

<link rel="stylesheet" type="text/css" href="Style_welcome.css">
<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	</head>
<body background="https://static.vecteezy.com/ti/vettori-gratis/p1/5021299-sfondo-azzurro-e-un-motivo-questo-sfondo-e-adatto-per-sfondi-cellulari-sfondi-di-presentazione-e-altro-gratuito-vettoriale.jpg" >
		<div id="header">
		<h1>Benvenuto Modalità Magazziniere</h1>
		</div>
	
		<!-- Container per Menu e CorpoPrincipale -->
		<div id="mainContainer" >
	
			<!-- Menu -->
			<div id="modello">
				<div id="select">
					<form action="ProdottoServlet" method="get">
						<label>Select</label>
						<input type="hidden" name="azione" value="selectm"><br>
						<input type="submit" value="Invio">
				    </form>
				</div>
				
				<div id="update">
					<form action="ProdottoServlet" method="get">
						<label>Update</label><br>
						<input type="hidden" name="azione" value="updatem">
						<label>Indice:</label>
						<input type="number" name="id" min=1 >
						<label>Quantita:</label>
						<input type="text" name="quantita"><br>
						<input type="submit" value="Invio"><br>
					</form>
				</div>
				
				<div id="insert">
					<form action="ProdottoServlet" method="get">
						<label>Insert</label><br>
						<input type="hidden" name="azione" value="insertm">
						<label>Prodotto:</label>
						<input type="text" name="nome">
						<label>Quantita:</label>
						<input type="text" name="quantita">
						<label>Prezzo:</label>
						<input type="text" name="prezzo"><br>
						<input type="submit" value="Invio"><br>
					</form>
				</div>
				
				<div id="delete">
					<form action="ProdottoServlet" method="get">
						<label>Delete</label><br>
						<input type="hidden" name="azione" value="deletem">
						<label>Indice:</label><br>
						<input type="number" name="id"><br>
						<input type="submit" value="Invio"><br>
					</form>
				</div>
		</div>
			<!-- CorpoPrincipale -->
			<div>
				<table  border="1" >
			<%
				List<Prodotto> utenti = (List<Prodotto>) request.getAttribute("utente1");
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
	</body>