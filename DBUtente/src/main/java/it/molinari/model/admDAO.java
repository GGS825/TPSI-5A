package it.molinari.model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class admDAO extends DAO{
	
	public List<Utente> adm_getLista() {
		List<Utente> result = new ArrayList<>();
		

		String query="select * from user";
		
		try 
		{
			
			Statement stato=connesione().createStatement(); 
			ResultSet risultato=stato.executeQuery(query);
			while(risultato.next())
			{
				
				result.add(new Utente(risultato.getInt("id"),risultato.getString("utente"),risultato.getString("ruolo")));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}

	public boolean adm_update(String n,String id) {
		int ids=Integer.parseInt(id);
		
		String query="update user set ruolo='"+n+"' where id="+ids+"";
		int risultato=0;
		try 
		{
			
			Statement stato=connesione().createStatement(); 
			risultato=stato.executeUpdate(query);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(risultato>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean adm_insert(String utente,String password)
	{
		
		String query="insert into user(utente,password,ruolo) values('"+utente+"','"+password+"','magaz') ";
		int risultato=0;
		try 
		{
			
			Statement stato =connesione().createStatement();
			risultato=stato.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(risultato>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean adm_delete(String id)
	{
		int ids=Integer.parseInt(id);
		String query="delete from user where id="+ids+"";
		int risultato=0;
		try 
		{
			
			Statement stato=connesione().createStatement(); 
			risultato=stato.executeUpdate(query);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		if(risultato>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean adm_insert_u(String utente,String password)
	{
		String query="insert into user(utente,password,ruolo) values('"+utente+"','"+password+"','utent') ";
		int risultato=0;
		try 
		{
			
			Statement stato =connesione().createStatement();
			risultato=stato.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(risultato>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}