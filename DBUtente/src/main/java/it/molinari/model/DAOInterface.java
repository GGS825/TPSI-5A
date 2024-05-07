package it.molinari.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface DAOInterface {

	public List<Utente> adm_getLista();

	public boolean adm_update(String n,String id);

	public boolean adm_insert(String n);

	public boolean adm_delete(String id);

}
