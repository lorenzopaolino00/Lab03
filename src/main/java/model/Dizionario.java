package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dizionario {
	
	private String st = "";
	List<String> ita = new LinkedList<String>();
	List<String> eng = new LinkedList<String>();
	
	public void loadDictionary(String language){
		
		st = language;
		
		try {
			FileReader fr = new FileReader("src\\main\\resources\\" + language);
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine()) != null) {
				if(language.compareTo("Italian.txt") == 0) {
					ita.add(word);
				}
				else {
					eng.add(word);
				}
			}
			
			br.close();
			
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> l = new LinkedList<RichWord>();
		for(String s: inputTextList) {
			if(st.compareTo("Italian.txt") == 0) {
				RichWord r;
				if(ita.contains(s)) {
					r = new RichWord(s, true);
				}
				else {
					r = new RichWord(s, false);
				}
				l.add(r);
			}
			
			if(st.compareTo("English.txt") == 0) {
				RichWord r;
				if(eng.contains(s)) {
					r = new RichWord(s, true);
				}
				else {
					r = new RichWord(s, false);
				}
				l.add(r);
			}
		}
		
		return l;
	}
	
}
