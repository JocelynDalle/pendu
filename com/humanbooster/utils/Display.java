package com.humanbooster.utils;

public class Display {
	public void printTitle() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("                    LE PENDU v1.2 @Jocelyn Dalle ");
		System.out.println("----------------------------------------------------------------------");
	}

	public void printRulesOnePlayers() {
		System.out.println("\n----------------------------------------------------------------------");
		System.out.println("Vous allez devoir retrouver un mot caché généré par l'ordinateur !");
		System.out.println("Un symbole _ correspond à une lettre cachée");
		System.out.println("Proposez toutes les lettres du mot pour remporter la partie");
		System.out.println("Vous avez droit à 5 erreurs au total pour retrouver le mot");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\n\n\n");
	}

	public void printRulesTwoPlayers() {
		System.out.println("\n----------------------------------------------------------------------");
		System.out.println("Vous allez devoir retrouver un mot caché par un ami !");
		System.out.println("Un symbole _ correspond à une lettre cachée");
		System.out.println("Proposez toutes les lettres du mot pour remporter la partie");
		System.out.println("Vous avez droit à 5 erreurs au total pour retrouver le mot");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\n\n\n");
	}

	public void printHangedGuy() {
		System.out.println("\n\n\n");
		System.out.println("  ,==========Y===");
		System.out.println("  ||  /      |   ");
		System.out.println("  || /       |   ");
		System.out.println("  ||/        O   ");
		System.out.println("  ||        /|\\ ");
		System.out.println("  ||        /|   ");
		System.out.println("  ||             ");
		System.out.println(" /||             ");
		System.out.println("//||             ");
		System.out.println("============     ");
	}

	public void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}

	}
}
