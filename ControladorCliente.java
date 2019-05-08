package Controles;


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
		Cliente cliente = new Cliente(nome, endereco, contato, cpf);
		if(RepositorioCliente.getInstance().addCliente(cliente)) {
			return true;
		}
		return false;
	}
	public boolean removerCliente(String cpf) {

		if(RepositorioCliente.getInstance().removerCliente(cpf)) {
			return true;
		}
		return false;
	}
	
	public boolean editarCliente(String cpf, String novoEndereco ) {
		if(RepositorioCliente.getInstance().editarCliente(cpf, novoEndereco)) {
			return true;
		}
		return false;
	}
	
	public Cliente buscarCliente(String cpf) {
		Cliente cliente = RepositorioCliente.getInstance().buscarCliente(cpf);
		return cliente;
	}
	
}	





















