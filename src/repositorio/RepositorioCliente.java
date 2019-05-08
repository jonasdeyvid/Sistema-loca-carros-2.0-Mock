package repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Cliente;

public class RepositorioCliente {
	private static RepositorioCliente repositorio;
	private List<Cliente> clientes;
	
	private RepositorioCliente() {
		clientes = new ArrayList<Cliente>();
	}
	
	public static RepositorioCliente getInstance() {
		if(repositorio == null) {
			return repositorio = new RepositorioCliente();
		}
		return repositorio;
	}
	
	
	public boolean addCliente(Cliente client) {
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(client.getCpf())) {
				return false;
			}
		}
		clientes.add(client);
		//bloco pro hibernate
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(client);
		manager.getTransaction().commit();
		fabrica.close();
		manager.close();
		return true;

	}
	
	public boolean removerCliente(String cpf) {
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				clientes.remove(cliente);
				return true;
			}
		}
		return false;
	}
	
	public boolean editarCliente(String cpf , String novoEndereco) {
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				cliente.setEndereco(novoEndereco);
				return true;
			}
		}
		return false;
	}
	
	public Cliente buscarCliente(String cpf) {
		for (Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	
}














