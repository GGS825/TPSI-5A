package it.molinari.model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MazDAO  extends DAO{
		
		public List<Prodotto> maz_getLista() {
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

		public boolean maz_update(String id,String n) {
			int ids=Integer.parseInt(id);
			float quantitas=Float.parseFloat(n);
			String query="update prodotto set quantita='"+quantitas+"' where id="+ids+"";
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

		public boolean maz_insert(String nome, String quantita, String prezzo)
		{
			float quantitas=Float.parseFloat(quantita);
			float prezzos=Float.parseFloat(prezzo);
			
			String query="insert into prodotto(nome,quantita,prezzo) values('"+nome+"','"+quantitas+"','"+prezzos+"'); ";
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

		public boolean maz_delete(String id)
		{
			int ids=Integer.parseInt(id);
			
			String query="delete from prodotto where id="+ids+"";
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
		
}
