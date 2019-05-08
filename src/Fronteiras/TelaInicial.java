package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCliente;
import Entidades.Cliente;

public class TelaInicial {
	
	public static void main(String[] args) {
		boolean parar = false;
		int escolha;
		Scanner input = new Scanner(System.in);
		while(!parar) {
			System.out.println(" [1] Cadastrar Cliente \n [2] Remover Cliente \n [3] Editar Cliente \n "
					+ "[4] Buscar Cliente \n [5] Mostrar Clientes \n [6] Alugar Carro \n [7] Devolver Carro \n [8] Adicionar Carro \n"
					+ " [9] Remover Carro \n [10] Editar preço do carro \n [11] Buscar carro \n [12] Mostrar Carros Disponiveis \n "
					+ "[13] Todos os Carros" );
			escolha = input.nextInt();
			switch(escolha) {
			case 1:
				TelaCadastrarCliente.mostrar();
				break;
			case 2:
				TelaRemoverCliente.mostrar();
				break;
			case 3: 
				TelaEditarCliente.mostrar();
				break;
				
			case 4:
				TelaBuscarCliente.mostrar();
				break;
				
			case 5:
				TelaMostrarClientes.mostrar();
				break;
				
			case 6:
				TelaAlugarCarro.mostrar();
				break;
				
			case 7:
				TelaDevolverCarro.mostrar();
				break;
			case 8:
				TelaAddCarro.mostrar();
				break;
			case 9:
				TelaRemoverCarro.mostrar();
				break;
			case 10:
				TelaEditarPrecoCarro.mostrar();
				break;
			case 11:
				TelaBuscarCarro.mostrar();
				break;
			case 12:
				TelaCarrosDisponiveis.mostrar();
				break;
			case 13:
				TelaTodosCarros.mostrar();
				break;
			default:
				
			}
			
				
		}
	}
}
