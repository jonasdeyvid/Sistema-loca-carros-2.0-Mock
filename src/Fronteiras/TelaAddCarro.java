package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCarro;

public class TelaAddCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o modelo do carro:");
		String modelo = input.nextLine();
		System.out.println("Digite a placa do carro:");
		String placa = input.nextLine();
		System.out.println("Digite a cor do carro:");
		String cor =  input.nextLine();
		System.out.println("Digite o ano do carro:");
		int ano= input.nextInt();
		System.out.println("Digite o preço de Aluguel do carro:");
		float precoAluguel = input.nextFloat();
		
		if(ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel)) {
			System.out.println("carro adicionado com sucesso");
		}else {
			System.out.println("erro ao adicionar carro");
		}
	}

}
