package it.molinari.model;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DAO {

	private static final String url = "jdbc:mysql://127.0.0.1:3306/ge";
	private static final String login = "root";
	private static final String paswd = "";
	private Connection p = null;
	
	public Connection connesione()
	{
		
		try 
		{
			
			p=DriverManager.getConnection(url, login, paswd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return p;
	}
	





}