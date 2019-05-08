package repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Carro;
import Entidades.Cliente;

public class RepositorioCliente {
	private static RepositorioCliente repositorio;
	private List<Cliente> clientes;
	protected EntityManager entityManager;
	
	private RepositorioCliente() {
		clientes = new ArrayList<Cliente>();
		entityManager = getEntityManager();
	}
	
	public static RepositorioCliente getInstance() {
		if(repositorio == null) {
			return repositorio = new RepositorioCliente();
		}
		return repositorio;
	}
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public boolean addCliente(Cliente client) {
			if(buscarCliente(client.getCpf()) != null) {
				return false;
			}
		
		clientes.add(client);
		//bloco pro hibernate
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();
		return true;

	}
	
	public boolean removerCliente(String cpf) {
		Cliente cliente = buscarCliente(cpf);
		if (cliente == null) {
			return false;
		}
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		return true;
	}
	
	public boolean editarCliente(String cpf , String novoEndereco) {
		Cliente cliente = buscarCliente(cpf);
		if(cliente == null) {
			return false;
		}
		cliente.setEndereco(novoEndereco);
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		return true;
	}
	
	public Cliente buscarCliente(String cpf) {
		Cliente cliente = null;
		ArrayList<Cliente> clientesBD = new ArrayList<Cliente>(getClientes());
		for (Cliente c : clientesBD) {
			if(c.getCpf().equals(cpf)) {
				cliente = c;
				return cliente;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
	}
	
}














