package com.humanbooster.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.humanbooster.business.Enigma;
import com.humanbooster.business.Mode;
import com.humanbooster.business.Word;
import com.humanbooster.service.PenduService;
import com.humanbooster.utils.Display;

public class PenduImpl implements PenduService {

	public boolean onePlayerMode() {
		ArrayList<Character> enigma = new ArrayList<Character>();
		ArrayList<Character> awnser = new ArrayList<Character>();
		Display dsp = new Display();
		Word wd = new Word();
		dsp.printRulesOnePlayers();

		// le joueur 1 saisit un mot que devra deviner le joueur 2
		String enigmaString = wd.getWordGame().toUpperCase();

		// conversion du String en <List>Character de lettres contenant la
		// solution
		enigma = stringToList(enigmaString);

		// pour afficher la solution depuis la List<Character> (Test et Debu)
		// ps.printList(enigma);
		// conversion du String en <List>Character de symbole '_' pour indiquer
		// les lettres non trouvées
		awnser = createAwnser(enigmaString);

		// pour effectuer le jeu et renvoyer true en cas de victoire ou false en
		// cas de défaite
		boolean win = playPendu(enigma, awnser);

		return win;
	}

	public boolean twoPlayerMode() {
		ArrayList<Character> enigma = new ArrayList<Character>();
		ArrayList<Character> awnser = new ArrayList<Character>();
		Display dsp = new Display();
		dsp.printRulesTwoPlayers();

		// le joueur 1 saisit un mot que devra deviner le joueur 2
		String enigmaString = getEnigma().toUpperCase();
		dsp.clearScreen();
		// conversion du String en <List>Character de lettres contenant la
		// solution
		enigma = stringToList(enigmaString);

		// pour afficher la solution depuis la List<Character> (Test et Debu)
		// ps.printList(enigma);
		// conversion du String en <List>Character de symbole '_' pour indiquer
		// les lettres non trouvées
		awnser = createAwnser(enigmaString);

		// pour effectuer le jeu et renvoyer true en cas de victoire ou false en
		// cas de défaite
		boolean win = playPendu(enigma, awnser);
		return win;
	}

	public boolean enigmaMode() {
		ArrayList<Character> enigmaGame = new ArrayList<Character>();
		ArrayList<Character> awnserGame = new ArrayList<Character>();
		Display dsp = new Display();
		Word wd = new Word();
		Enigma eg = new Enigma();
		dsp.printRulesOnePlayers();

		// le joueur 1 saisit un mot que devra deviner le joueur 2
		Enigma enigGame = eg.getEnigmaGame();
		String questionTemp = enigGame.getQuestion().toUpperCase();

		// conversion du String en <List>Character de lettres contenant la
		// solution
		enigmaGame = stringToList(questionTemp);

		// pour afficher la solution depuis la List<Character> (Test et Debu)
		// ps.printList(enigma);
		// conversion du String en <List>Character de symbole '_' pour indiquer
		// les lettres non trouvées
		awnserGame = createAwnser(questionTemp);

		// pour effectuer le jeu et renvoyer true en cas de victoire ou false en
		// cas de défaite
		boolean win = playPenduEnigma(enigmaGame, awnserGame, enigGame.getAwnser());
		return true;
	}

	public int getMode() {
		Mode mode = new Mode();
		List<Mode> modes = mode.getModes();
		int i = 0;
		for (Mode md : modes) {
			i++;
			System.out.println(i + ") " + md.getName() + " " + md.getDesc());
		}

		System.out.println("choisissez votre mode :");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		return modes.get(choice - 1).getId();

	}

	public void printList(ArrayList<Character> list) {
		for (char cr : list) {
			System.out.print(cr);
		}
	}

	public ArrayList<Character> stringToList(String name) {
		ArrayList<Character> enigma = new ArrayList<Character>();

		for (int i = 0; i < name.length(); i++) {
			enigma.add(name.charAt(i));
		}
		return enigma;
	}

	public ArrayList<Character> createAwnser(String name) {
		ArrayList<Character> awnser = new ArrayList<Character>();

		for (int i = 0; i < name.length(); i++) {
			awnser.add('_');
		}
		return awnser;
	}

	public boolean playPendu(ArrayList<Character> enigma, ArrayList<Character> awnser) {
		Scanner sc = new Scanner(System.in);
		char prop;
		int tries = 5;
		boolean isInEnigma;
		while (tries > 0) {

			System.out.println("----------------------------------------------------------------------");
			printTries(tries);
			System.out.println("");
			printList(awnser);
			System.out.println("\n\nProposez une lettre");
			prop = sc.next().toUpperCase().charAt(0);

			isInEnigma = false;
			for (int i = 0; i < awnser.size(); i++) {
				if (enigma.get(i).equals(prop)) {
					awnser.set(i, prop);
					isInEnigma = true;
				}
			}
			if (!isInEnigma) {
				tries--;
			}

			if (checkWin(awnser)) {
				printList(awnser);
				return true;
			}

		}
		System.out.println("C'est perdu... la bonne réponse était : ");
		printList(enigma);
		return false;

	}

	public boolean playPenduEnigma(ArrayList<Character> enigma, ArrayList<Character> awnser, String awnsQuest) {
		Scanner sc = new Scanner(System.in);
		char prop;
		int lettersLeft = 10;

		char specTab[] = { ' ', '?', '!', '-', '\'' };
		for (char spec : specTab) {
			for (int i = 0; i < awnser.size(); i++) {
				if (enigma.get(i).equals(spec)) {
					awnser.set(i, spec);
				}
			}
		}
		while (lettersLeft > 0) {

			System.out.println("\n----------------------------------------------------------------------");
			printList(awnser);
			System.out.println("\n----------------------------------------------------------------------");

			System.out.println("Vous pouvez encore proposer " + lettersLeft + " lettres");
			System.out.println("\n\nProposez une lettre");
			prop = sc.next().toUpperCase().charAt(0);

			for (int i = 0; i < awnser.size(); i++) {
				if (enigma.get(i).equals(prop)) {
					awnser.set(i, prop);
				}
			}
			lettersLeft--;
		}
		System.out.println("----------------------------------------------------------------------");
		printList(awnser);
		System.out.println("\n----------------------------------------------------------------------");
		System.out.println("Quelle est votre réponse à l'énigme ?");
		
		for (int i = 0; i < awnsQuest.length(); i++) {
			System.out.print("#");
		}
		System.out.print("\n");
		String awnsPlayer = sc.next().toUpperCase();

		if (awnsPlayer.equals(awnsQuest.toUpperCase())) {
			System.out.println("C'est gagné !!!");
			return true;
		} else {
			System.out.println("C'est perdu... la bonne réponse était : " + awnsQuest);
			return false;
		}

	}

	public void printTries(int tries) {
		System.out.print("\nDroits à l'erreur restants : ");
		for (int i = 0; i < tries; i++) {
			System.out.print("O ");
		}
		for (int i = 0; i < 5 - tries; i++) {
			System.out.print("X ");
		}
	}

	public String getEnigma() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le mot à deviner (pas de chiffre, par de caractère spécial)");
		return sc.nextLine();
	}

	public boolean checkWin(ArrayList<Character> awnser) {

		for (int i = 0; i < awnser.size(); i++) {
			if (awnser.get(i) == '_') {
				return false;
			}

		}
		return true;
	}

}
