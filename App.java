import java.util.ArrayList;

import com.humanbooster.service.PenduService;
import com.humanbooster.serviceImpl.PenduImpl;
import com.humanbooster.utils.Display;

public class App {

	public static void main(String[] args) {

		PenduService ps = new PenduImpl();
		Display dsp = new Display();
		boolean win = false;

		// affichage du titre et des règles
		dsp.printTitle();
		int mode = ps.getMode();
		switch (mode) {
		case 1: {
			win = ps.onePlayerMode();
			break;
		}

		case 2: {
			win = ps.twoPlayerMode();
			break;
		}
		
		case 3: {
			win = ps.enigmaMode();
			break;
		}
		}

		if (win) {
			System.out.println("\n\ngagné !");
		} else {
			dsp.printHangedGuy();
		}
	}
}
