package it.molinari.model;

public class Utente {
	
	private int id;
	private String utente;
	private String ruolo;
	public Utente(int id,String utente,String ruolo)
	{
		this.id = id;
		this.utente = utente;
		this.ruolo = ruolo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
