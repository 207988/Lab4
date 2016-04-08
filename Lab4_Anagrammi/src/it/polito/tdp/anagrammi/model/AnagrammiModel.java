package it.polito.tdp.anagrammi.model;
import java.util.*;

import it.polito.tdp.anagrammi.db.ParolaDAO;

public class AnagrammiModel {

	private List<String>parole;
	private List<Lettera>lettere;	
	private int lunghezza;
	
	public List<Parola> elencoAnagrammi(String s){		
		parole=new ArrayList<String>();
		lettere=new ArrayList<Lettera>();
		
		lunghezza=s.length();
		//copio lettere parola in lista
		for(int h=0;h<s.length();h++){
			Lettera l=null;
			int pos=lettere.indexOf(new Lettera(""+s.charAt(h)));
			if(pos!=-1)
				l=lettere.get(pos);
			if(l==null)
				lettere.add(new Lettera(""+s.charAt(h)));	
			else
				l.aggiornaConteggio();
				
		}
		//avvio ricorsione
		this.cercaAnagramma("");
		//debug
		for(String st:parole){
			System.out.println(st);
		}
		System.out.println(parole.size());
		
		
		//PORTING DA STRIGN A PAROLA E CONTROLLO VALIDITA
		List<Parola>temp=new ArrayList<Parola>();
		ParolaDAO dao=new ParolaDAO();
		for(String sr:parole){
			temp.add(new Parola(sr,dao.checkParola(sr)));
		}
		
		
		return temp;
	}
	
	private void cercaAnagramma(String s){	
		//se la lunghezza della stringa = a parola iniziale controlla se è già nei risultati e ritorna
		if(s.length()==lunghezza){
			if(checkAnagramma(s)==false)
				parole.add(s);			
			return;		
		}
		//cicla le lettere
		for(int z=0;z<lettere.size();z++){
			//1-controlla che la lettera non sia già nella stringa ricorsiva
			//2-ricorsione con param stringa ricorsiva + ch in pos z lista lettere
			
			String temp=s.replaceAll(lettere.get(z).getLettera(), "");;
			//temp.replaceAll(lettere.get(z).getLettera(), "");
			
			int charOcc=s.length()-temp.length();
			if(charOcc!=lettere.get(z).getConteggio())
				cercaAnagramma(s+lettere.get(z));
		}	
		
	}
	
	private boolean checkAnagramma(String s){
		if(parole.contains(s)==true)
			return true;
		else
			return false;
	}
}
