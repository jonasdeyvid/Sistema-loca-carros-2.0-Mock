package DAOS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;

import Entidades.Carro;

public class CarroDAO {
	protected EntityManager entityManager;

	public CarroDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public boolean addCarro(Carro carro) {
		if (true) {
			entityManager.getTransaction().begin();
			entityManager.persist(carro);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		}
		return false;
	}
	
	public void setEntityManager(EntityManager et) {
		this.entityManager = et;
	}

	public boolean removerCarroPelaPlaca(String placa) {
		Carro carro = new Carro();
//		if (carro == null) {
//			return false;
//		}
		entityManager.getTransaction().begin();
		entityManager.remove(carro);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	
	public boolean removerCarro(Carro c) {
		if(c != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(c);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		}
		return false;
	}

	public Carro buscarCarro(String placaBusca) {
		ArrayList<Carro> cs = new ArrayList<Carro>(getCarros());
		Carro c = null;
		for(Carro carro : cs) {
			if(carro.getPlaca().equals(placaBusca)) {
				c = carro;
			}
		}
		
		return c;
	}

	

	public boolean editarPrecoCarro(String placa, double novoPreco) {
		Carro carro = buscarCarro(placa);
		if(carro == null) {
			return false;
		}
		carro.setPrecoAluguel(novoPreco);
		entityManager.getTransaction().begin();
		entityManager.merge(carro);
		entityManager.getTransaction().commit();
		return true;
	}
	
	public boolean setCarroAlugado(Carro carro) {
		if(carro == null) {
			return false;
		}
		entityManager.getTransaction().begin();
		entityManager.merge(carro);
		entityManager.getTransaction().commit();
		return true;
	}

	public List<Carro> carrosDisponiveis(){
		List<Carro> carrosDoBD = getCarros();
		List<Carro> carrosDisponieis = new ArrayList<Carro>();
		for (Carro carro : carrosDoBD) {
			if(!carro.isAlugado()) {
				carrosDisponieis.add(carro);
			}
		}
		return carrosDisponieis;
	}
	@SuppressWarnings("unchecked")
	public List<Carro> getCarros() {
		return entityManager.createQuery("FROM " + Carro.class.getName()).getResultList();
	}

}
