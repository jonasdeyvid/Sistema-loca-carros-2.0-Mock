package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCliente;

public class TelaBuscarCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o CPF do Cliente");
		String cpf = input.nextLine();
		if(ControladorCliente.getInstance().buscarCliente(cpf) == null) {
			System.out.println("Cliente não existe");
		}else {
			System.out.println(ControladorCliente.getInstance().buscarCliente(cpf));
		}
	}
}
