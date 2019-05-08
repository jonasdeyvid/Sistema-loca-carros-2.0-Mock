package repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Carro;

public class RepositorioCarro {
	private static RepositorioCarro repositorio;
	private List<Carro> carros;
	
	private RepositorioCarro() {
		carros = new ArrayList<Carro>();
	}
	public static RepositorioCarro getInstance() {
		if(repositorio == null) {
			return repositorio = new RepositorioCarro();
		}
		return repositorio;
	}
	
	public boolean addCarro(Carro carro) {
		if(buscarCarro(carro.getPlaca()) == null ) {
			carros.add(carro);
			//bloco pro hibernate
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
			EntityManager manager = fabrica.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(carro);
			manager.getTransaction().commit();
			fabrica.close();
			manager.close();
			return true;
		}
		return  false;
	}
	
	public boolean removerCarro(String placa) {
		if(buscarCarro(placa) == null) {
			return false;
		}
		carros.remove(buscarCarro(placa));
		return true;
	}

	public Carro buscarCarro(String placa) {
		for (Carro carro : carros) {
			if(carro.getPlaca().equals(placa)) {
				return carro;
			}
		}
		return null;
	}
	
	public boolean editarPrecoCarro(String placa, double novoPreco) {
		if(buscarCarro(placa) == null) {
			return false;
		}
		buscarCarro(placa).setPrecoAluguel(novoPreco);
		return true;
	}
	
	public List<Carro> carrosDisponiveis(){
		List<Carro> carrosDisponieis = new ArrayList<Carro>();
		for (Carro carro : carros) {
			if(!carro.isAlugado()) {
				carrosDisponieis.add(carro);
			}
		}
		return carrosDisponieis;
	}
	public List<Carro> getCarros() {
		return carros;
	}

	
}








