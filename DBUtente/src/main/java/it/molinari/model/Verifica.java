package it.molinari.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Verifica {
	private boolean accesso;
	
	//costruttore
	public Verifica(){
		this.accesso=false;
	};
	
	public boolean getAccesso()
	{
		return this.accesso;
	}
	
	public String accesso(String user,String pass)
	{
		String a=null;
		
		String url = "jdbc:mysql://127.0.0.1:3306/ge";
		String login = "root";
		String paswd = "";
		String query="select * from user;";
		try 
		{
			
			Connection p=DriverManager.getConnection(url, login, paswd);
			Statement stato=p.createStatement(); 
			ResultSet risultato=stato.executeQuery(query);
			while(risultato.next())
			{
				String u=risultato.getString("utente");
				String pa=risultato.getString("password");
				if(u.equals(user) && pa.equals(pass))
				{
					this.accesso=true;
					a=risultato.getString("ruolo");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
}
