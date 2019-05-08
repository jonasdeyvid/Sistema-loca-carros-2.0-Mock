package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCliente;

public class TelaEditarCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o CPF do Cliente a ser editado");
		String cpf = input.nextLine();
		System.out.println("Digite o novo endereço");
		String endereco = input.nextLine();
		
		if(ControladorCliente.getInstance().editarCliente(cpf, endereco)) {
			System.out.println("Cliente editado com sucesso");
		}else {
			System.out.println("erro ao editar cliente");
		}
	}
}
