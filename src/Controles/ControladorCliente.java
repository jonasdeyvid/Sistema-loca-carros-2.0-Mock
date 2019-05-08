package Controles;


import java.util.List;

import Entidades.Cliente;

public class ControladorCliente {
	private static ControladorCliente controler = null;
	
	private ControladorCliente() {
		
	}
	
	public static ControladorCliente getInstance() {
		if(controler == null) {
			return controler = new ControladorCliente();
		}
		return controler;
	}
	
	public boolean addCliente(String nome, String endereco, int contato, String cpf) {

		if(nome == null || nome.equals("")  || nome.equals("     ")) return false;
		nome = nome.replace(" ", " ");
		if(nome.length() == 0) return false;
		if(endereco == null || endereco.equals("") || endereco.equals("\n") || endereco.contains("@-ç")) return false;
		if(cpf.length() != 11) return false;
		String cont = Integer.toString(contato);
		if(cont.length() < 8) return false;
		if(!(nome.substring(0, 3).matches("[A-Z a-z]*")) )return false;
		if(!(endereco.substring(0, 3).matches("[A-Z a-z]*")) )return false;

		Cliente cliente = new Cliente(nome, endereco, contato, cpf);
		if(RepositorioCliente.getInstance().addCliente(cliente)) {
			return true;
		}
		return false;
	}
	
	public boolean removerCliente(String cpf) {
		if(cpf == null) return false;
		if(cpf.length() != 11) return false;
		if(RepositorioCliente.getInstance().removerCliente(cpf)) {
			return true;
		}
		return false;
	}
	
	public boolean editarCliente(String cpf, String endereco ) {
		if(cpf == null) return false;
		if(endereco == null || endereco.equals("") || endereco.equals("\n")) return false;
		if(!(endereco.substring(0, 3).matches("[A-Z a-z]*")) )return false;
		if(cpf.length() != 11) return false;

		if(RepositorioCliente.getInstance().editarCliente(cpf, endereco)) {
			return true;
		}
		return false;
	}
	
	public Cliente buscarCliente(String cpf) {
		if(cpf == null) return null;
		Cliente cliente = RepositorioCliente.getInstance().buscarCliente(cpf);
		return cliente;
	}
	public List<Cliente> listaClientes(){
		return RepositorioCliente.getInstance().getClientes();
	}
	
	public boolean alugarCarro(String placa) {
		if(placa == null) return false;
		return ControladorCarro.getInstance().alugarCarro(placa);
	}
	public boolean devolverCarro(String placa) {
		return ControladorCarro.getInstance().devolverCarro(placa);
	}
	
	
}	





















