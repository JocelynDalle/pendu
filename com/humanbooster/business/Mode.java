package com.humanbooster.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mode {

	int id;
	String name;
	String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Mode(int id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Mode [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

	public Mode() {
		// TODO Auto-generated constructor stub
	}

	public Mode onePlayerMode() {
		Mode onePlayer = new Mode(1, "1 joueur", "Devinez un mot proposé par l'ordinateur");
		return onePlayer;
	}

	public Mode twoPlayersMode() {
		Mode onePlayer = new Mode(2, "2 joueurs", "Devinez un mot proposé par votre adversaire");
		return onePlayer;
	}

	public Mode guessEnigma() {
		Mode onePlayer = new Mode(3, "Mode énigme", "Deviner la question et trouvez la réponse");
		return onePlayer;
	}

	public List<Mode> getModes() {
		List<Mode> modes = new ArrayList<Mode>();
		Mode mode = new Mode();
		modes.add(mode.onePlayerMode());
		modes.add(mode.twoPlayersMode());
		modes.add(mode.guessEnigma());
		return modes;
	}

}
