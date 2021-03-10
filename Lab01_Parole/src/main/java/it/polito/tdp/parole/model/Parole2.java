package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Parole2 {
		
     ArrayList <String> elencoParole ;
	
	public Parole2() {
		
		elencoParole = new ArrayList <String>();
		
	}
	
	public void addParola(String p) {
		
		elencoParole.add(p);
		
	}
	
	public class OrdineAlfabetico implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			
			return o1.compareTo(o2);
		}
		
	}
	
	public List<String> getElenco() {
		
		Collections.sort(elencoParole, new OrdineAlfabetico());
		return elencoParole;
	}
	
	public void reset() {
		elencoParole.clear();
	}

	public void elimina(String daCancellare) {
		elencoParole.remove(daCancellare);
		
	}

	public String getStringa() {
		
		Collections.sort(elencoParole, new OrdineAlfabetico());
		
		String s="";
        for(int i=0; i<elencoParole.size() ; i++)
     	   s+=elencoParole.get(i)+"\n";
		
		return s;
	}


}