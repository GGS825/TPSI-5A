package it.molinari.service;

import it.molinari.model.*;

import java.util.ArrayList;
import java.util.List;

import it.molinari.controller.*;
public class UtenteService {

	//la pare della amministratore 
	public List<UtenteDTO> adm_getLista() {
		
		admDAO u=new admDAO();
		List<UtenteDTO> DTO=new ArrayList<>();
		
		for(Utente u1 : u.adm_getLista())
		{
			
			int u3=u1.getId();
			String u2=u1.getUtente();
			String u4=u1.getRuolo();
			DTO.add(new UtenteDTO(u3,u2,u4));
		}
		
		return DTO;
		
	}

	public boolean adm_update(String n,String id)
	{
		
		admDAO u=new admDAO();
		
		if(u.adm_update(n,id)==true)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	
	public boolean adm_insert(String utente,String password)
	{
		
		admDAO u=new admDAO();
		
		if(u.adm_insert(utente,password)==true)
		{
			return true;
		}else
		{
			return false;
		}
	}


	public boolean adm_delete(String id)
	{
		admDAO u=new admDAO();
		
		if(u.adm_delete(id)==true)
		{
			return true;
		}else
		{
			return false;
		}
	}

	public boolean adm_insert_u(String utente,String password)
	{
		
		admDAO u=new admDAO();
		
		if(u.adm_insert_u(utente,password)==true)
		{
			return true;
		}else
		{
			return false;
		}
	}


    
    //la parte della magazziniere
    public List<Prodotto> maz_getLista() {
		
		MazDAO u=new MazDAO();
		List<Prodotto> prodotti=u.maz_getLista();
		
		return prodotti;
		
	}
    
    public boolean maz_update(String id,String n)
	{
		
		MazDAO u=new MazDAO();
		
		if(u.maz_update(id,n)==true)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	
	public boolean maz_insert(String nome, String quantita, String prezzo)
	{
		
		MazDAO u=new MazDAO();
		
		if(u.maz_insert(nome,quantita,prezzo)==true)
		{
			return true;
		}else
		{
			return false;
		}
	}


	public boolean maz_delete(String id)
	{
		MazDAO u=new MazDAO();
		
		if(u.maz_delete(id)==true)
		{
			return true;
		}else
		{
			return false;
		}
	}

	//la parte cliente
	
	 public List<Prodotto> u_getLista() 
	{
			
			UtenteDAO u=new UtenteDAO();
			List<Prodotto> prodotti=u.u_getLista();
			
			return prodotti;
			
	}
	 
	 
	 public boolean u_acquista(String id,String p)
		{
			UtenteDAO u=new UtenteDAO();
			
			if(u.u_acquista(id,p)==true)
			{
				return true;
			}else
			{
				return false;
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
