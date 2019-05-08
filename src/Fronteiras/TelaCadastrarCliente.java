package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCliente;

public class TelaCadastrarCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite seu nome:");
		String nome = input.nextLine(); 
		
		System.out.println("Digite seu endereço:");
		String end = input.nextLine();
		
		System.out.println("Digite seu CPF: ");
		String cpf;
		cpf = input.nextLine();
		
		
		System.out.println("Digite seu telefone pra contato:");
		int tel = input.nextInt();
		

		if(ControladorCliente.getInstance().addCliente(nome, end, tel, cpf)) {
			System.out.println("Usuario Cadastrado com sucesso!");
		}else {
			System.out.println("Erro ao adicionar usuario");
		}
	}
}
