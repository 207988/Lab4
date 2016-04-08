package it.polito.tdp.anagrammi.model;

public class Lettera {

	private String lettera;
	private int conteggio;
	public Lettera(String lettera) {
		super();
		this.lettera = lettera;
		this.conteggio = 1;
	}
	
	public void aggiornaConteggio(){
		conteggio++;
	}

	public String getLettera() {
		return lettera;
	}

	public int getConteggio() {
		return conteggio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lettera == null) ? 0 : lettera.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettera other = (Lettera) obj;
		if (lettera == null) {
			if (other.lettera != null)
				return false;
		} else if (!lettera.equals(other.lettera))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return lettera;
	}
	
	

	
	
	
	
	
}
