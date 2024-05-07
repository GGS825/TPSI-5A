<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="it.molinari.model.UtenteDTO" %>
<%@ page import="java.util.List" %>

<link rel="stylesheet" type="text/css" href="Style_welcome.css">
<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	</head>
<body background="https://static.vecteezy.com/ti/vettori-gratis/p1/5021299-sfondo-azzurro-e-un-motivo-questo-sfondo-e-adatto-per-sfondi-cellulari-sfondi-di-presentazione-e-altro-gratuito-vettoriale.jpg" >
		<div id="header">
		<h1>Benvenuto Modalità Admin</h1>
		</div>
	
		<!-- Container per Menu e CorpoPrincipale -->
		<div id="mainContainer" >
	
			<!-- Menu -->
			<div id="modello">
				<div id="select">
					<form action="UtenteServlet" method="get">
						<label>Select</label>
						<input type="hidden" name="azione" value="selecta">
						<input type="submit" value="Invio"><br>
				    </form>
				</div>
				
				<div id="update">
					<form action="UtenteServlet" method="get">
						<label>Update</label>
						<input type="hidden" name="azione" value="update">
						<label>Indice:</label>
						<input type="number" name="id" min=2 >
						<label>Ruolo:</label>
						<select name="ruolo" >
							<option value="magaz">magazzino</option>
							<option value="clien">Client</option>
							<option value="utent">Null</option>
						</select>
						<input type="submit" value="Invio"><br>
					</form>
				</div>
				
				<div id="insert">
					<form action="UtenteServlet" method="get">
						<label>Insert Magazziniere</label>
						<input type="hidden" name="azione" value="insert">
						<label>User:</label>
						<input type="text" name="utente">
						<label>Password:</label>
						<input type="text" name="password">
						<input type="submit" value="Invio"><br>
					</form>
				</div>
				
				<div id="delete">
					<form action="UtenteServlet" method="get">
						<label>Delete</label>
						<input type="hidden" name="azione" value="delete">
						<label>Indice:</label>
						<input type="number" name="id" min=2>
						<input type="submit" value="Invio"><br>
					</form>
				</div>
				
				
		</div>
			<!-- CorpoPrincipale -->
			<div>
				<table  border="1" >
			<%
				List<UtenteDTO> utenti = (List<UtenteDTO>) request.getAttribute("utente1");
		 		if (utenti != null)
		 		{
		 			out.println("<tr>" + "<th>" +"ID" +"</th>"+ "<th>" +"User" +"</th>" + "<th>" +"Ruolo" +"</th>" +"</tr>");
					        for (UtenteDTO u : utenti) 
					 {
					    out.println("<tr>" + "<td>" +u.getId() + "<td>" +u.getUtente() +"<td>"+u.getRuolo()+"</td>"+"</td>"+"</td>" + "</tr>");
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