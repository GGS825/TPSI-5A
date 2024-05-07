package it.molinari.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO extends DAO{

	public List<Prodotto> u_getLista() {
		List<Prodotto> result = new ArrayList<>();
		

		String query="select * from prodotto";
		
		try 
		{
			
			Statement stato=connesione().createStatement(); 
			ResultSet risultato=stato.executeQuery(query);
			while(risultato.next())
			{
				
				result.add(new Prodotto(risultato.getInt("id"),risultato.getString("nome"),risultato.getFloat("quantita"),risultato.getFloat("prezzo")));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public boolean u_acquista(String id,String p) {
		int ids=Integer.parseInt(id);
		float quantitas=Float.parseFloat(p);
		int risultato1=0;
		
		String query1="select * from prodotto where id ='"+ids+"'";
		
		
		try 
		{
			
			Statement stato=connesione().createStatement();
			ResultSet risultato=stato.executeQuery(query1);
			while(risultato.next())
			{
				if(quantitas<=risultato.getFloat("quantita"))
				{
					float n=risultato.getFloat("quantita")-quantitas;
					String query2="update prodotto set quantita='"+n+"' where id="+ids+"";
					
					risultato1=stato.executeUpdate(query2);
				}
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(risultato1>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
