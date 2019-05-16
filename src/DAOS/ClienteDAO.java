package DAOS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import Entidades.Cliente;

public class ClienteDAO {

	protected EntityManager entityManager;
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	public SessionFactory sessionFactory;

	public ClienteDAO() {
		entityManager = getEntityManager();
	}
	
	public ClienteDAO(EntityManagerFactory entityManagerFactory) throws SQLException{
		this.factory = entityManagerFactory;
		//entityManager = getEntityManager();

	}
	
	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	public boolean addCliente(Cliente client) {  
		EntityManager entityManager = factory.createEntityManager();
	        try {
	            entityManager.getTransaction().begin();
	            entityManager.persist(client);
	            entityManager.getTransaction().commit();
	            return true;
	        }
	        finally {
	            if (entityManager != null) {
	                entityManager.close();
	            }
	        }

	}
	
	public boolean removerCliente(String cpf) {
        EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(cpf);
		entityManager.getTransaction().commit();
        entityManager.close();

		return true;
	}
	
	public boolean editarCliente(String cpf , String novoEndereco) {
        EntityManager entityManager = factory.createEntityManager();
        
        
		entityManager.getTransaction().begin();
		entityManager.merge("Eudasioso");
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	/*    
	 
	public boolean addCliente(Cliente client) {  
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
	*/
	public Cliente buscarCliente(String cpf) {
		Cliente cliente = null;
		List<Cliente> clientesBD = new ArrayList<Cliente>();
		clientesBD = getClientes();
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
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		return manager.createQuery("FROM " + Cliente.class.getName()).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}














