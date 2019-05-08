package Fronteiras;

import Controles.ControladorCarro;
import Entidades.Carro;

public class TelaCarrosDisponiveis {
	public static void mostrar() {
		for (Carro carro : ControladorCarro.getInstance().carrosDisponiveis()) {
			System.out.println(carro);

		}
	}
}
