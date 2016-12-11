package com.humanbooster.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enigma {
	int id;
	String question;
	String awnser;

	

	public Enigma(int id, String question, String awnser) {
		super();
		this.id = id;
		this.question = question;
		this.awnser = awnser;
	}



	public Enigma() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Enigma [id=" + id + ", question=" + question + ", awnser=" + awnser + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getAwnser() {
		return awnser;
	}



	public void setAwnser(String awnser) {
		this.awnser = awnser;
	}



	public Enigma getEnigmaGame() {
		List<Enigma> enigmas = new ArrayList<Enigma>();
		Random rng = new Random();
		Enigma en1 = new Enigma(1, "Quelle est la Capitale du Mexique, pays au sud des Etats-Unis ?", "Mexico");
		Enigma en2 = new Enigma(2, "Dans quelle discipline d'arts martiaux excelle le sportif Teddy Riner ?", "Judo");
		Enigma en3 = new Enigma(3, "Quelle forme géométrique pouvant etre rectangle ou isocele possede trois cotes ?", "Triangle");
		Enigma en4 = new Enigma(4, "Quel footballeur celebre a marque deux buts en finale de coupe du Monde pour l'Equipe de France ?", "Zidane");
		Enigma en5 = new Enigma(5, "Comment se nomme le reseau social bleu cree par Mark Zuckerberb ?", "Facebook");
		enigmas.add(en1);
		enigmas.add(en2);
		enigmas.add(en3);
		enigmas.add(en4);
		enigmas.add(en5);

		return enigmas.get(rng.nextInt(enigmas.size()));

	}

}
