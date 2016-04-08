package it.polito.tdp.anagrammi.model;

public class Parola {

	private String s;
	private boolean corretta;
	
	public Parola(String s,boolean flag) {
		super();
		this.s = s;
		corretta=flag;
	}
	public boolean isCorretta() {
		return corretta;
	}
	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}
	public String getS() {
		return s;
	}
	@Override
	public String toString() {
		return s;
	}
	
	
}
