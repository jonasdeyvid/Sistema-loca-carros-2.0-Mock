package Fronteiras;

import Controles.ControladorCliente;
import Entidades.Cliente;

public class TelaMostrarClientes {
	public static void mostrar() {
		
		for (Cliente cliente : ControladorCliente.getInstance().listaClientes()) {
			System.out.println(cliente + "\n");
		}
	}
}
