package com.humanbooster.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word {

	int id;
	String word;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", word=" + word + "]";
	}

	public Word(int id, String word) {
		super();
		this.id = id;
		this.word = word;
	}

	public Word() {
		// TODO Auto-generated constructor stub
	}

	public String getWordGame() {
		List<Word> words = new ArrayList<Word>();
		Random rng = new Random();
		Word savon = new Word(1, "savon");
		words.add(savon);
		Word casquette = new Word(2, "casquette");
		words.add(casquette);
		Word turquoize = new Word(3, "turquoize");
		words.add(turquoize);
		Word stylo = new Word(4, "stylo");
		words.add(stylo);
		Word ridicule = new Word(5, "ridicule");
		words.add(ridicule);

		return words.get(rng.nextInt(words.size())).word;

	}

}
