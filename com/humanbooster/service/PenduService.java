package com.humanbooster.service;

import java.util.ArrayList;

public interface PenduService {

	
	public boolean onePlayerMode();

	public boolean twoPlayerMode();
	
	public boolean enigmaMode();

	public void printList(ArrayList<Character> list);

	public ArrayList<Character> stringToList(String name);

	public ArrayList<Character> createAwnser(String name);

	public boolean playPendu(ArrayList<Character> enigma, ArrayList<Character> awnser);

	public String getEnigma();

	public int getMode();

}
