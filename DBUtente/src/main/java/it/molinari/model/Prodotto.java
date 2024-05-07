package it.molinari.model;

public class Prodotto {

	private int id;
	private String nome;
	private float quantita;
	private float prezzo;
	
	public Prodotto(int id, String nome, float quantita, float prezzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getQuantita() {
		return quantita;
	}
	public void setQuantita(float quantita) {
		this.quantita = quantita;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
}
