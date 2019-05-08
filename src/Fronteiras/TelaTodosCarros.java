package Fronteiras;

import Controles.ControladorCarro;
import Entidades.Carro;

public class TelaTodosCarros {
	public static void mostrar() {
		for (Carro carro : ControladorCarro.getInstance().getCarros()) {
			System.out.println(carro);

		}
	}
}
