package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import DAOS.CarroDAO;
import DAOS.ClienteDAO;
import Entidades.Carro;
import Entidades.Cliente;

class CarroDAOTeste {
	
	@Mock
	EntityManager entityManager = Mockito.mock(EntityManager.class);
	
	@Mock
	EntityTransaction entityTransaction = Mockito.mock(EntityTransaction.class);
	
	@Mock
	Query query = Mockito.mock(Query.class);
	
	 @Mock
	private CarroDAO carroDAO;
	
	@Before
	public void setUp() throws Exception{
		Mockito.when(entityManager.getTransaction()).thenReturn(entityTransaction);
		Mockito.doNothing().when(entityTransaction).begin();
		Mockito.doNothing().when(entityTransaction).commit();
		Mockito.doNothing().when(entityManager).persist(Mockito.any(Object.class));
		Mockito.doNothing().when(entityManager).remove(Mockito.any(Object.class));
		Mockito.doNothing().when(entityManager).merge(Mockito.any(Object.class));
		EntityManagerFactory entityManagerFactory = Mockito.mock(EntityManagerFactory.class);
	    Mockito.when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		
	}
	@Test
	public void testaListar() {
		List<Carro> carros = new ArrayList<Carro>();
		Carro c1 = new Carro("gol1", "qwe1234", "branco", 2010, 20);
		Carro c2 = new Carro("gol2", "qwe1235", "branco", 2010, 20);
		Carro c3 = new Carro("gol3", "qwe1236", "branco", 2010, 20);
		Carro c4 = new Carro("gol4", "qwe1237", "branco", 2010, 20);
		Carro c5 = new Carro("gol5", "qwe1238", "branco", 2010, 20);
		carros.add(c1);
		carros.add(c2);
		carros.add(c3);
		carros.add(c4);
		carros.add(c5);
		Mockito.when(entityManager.createQuery(Mockito.startsWith("FROM " + Carro.class.getName()))).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(carros);
		assertEquals(query.getResultList().size(), 5);
        assertEquals(query.getResultList().get(0), c1);
	}
	
	
	@Test
	public void testaAdicaoCarro() {
		Mockito.when(entityManager.getTransaction()).thenReturn(entityTransaction);
		
		CarroDAO cd = new CarroDAO();
		cd.setEntityManager(entityManager);
		Carro c = new Carro("jetta", "qwe1234", "preto", 2015, 30);
		cd.addCarro(c);
		Mockito.verify(entityManager).persist(c);
        Mockito.verify(entityManager).close();
        Mockito.verify(entityTransaction).begin();
        Mockito.verify(entityTransaction).commit();
	}
	
	@Test
	public void testaRemocaoCarro() {
		Mockito.when(entityManager.getTransaction()).thenReturn(entityTransaction);
		
		CarroDAO cd2 = new CarroDAO();
		cd2.setEntityManager(entityManager);
		Carro c = new Carro("jetta", "qwe1224", "preto", 2015, 30);
		cd2.removerCarro(c);
		
		Mockito.verify(entityManager).remove(c);
        Mockito.verify(entityManager).close();
        Mockito.verify(entityTransaction).begin();
        Mockito.verify(entityTransaction).commit();
	}
	
	@Test
	public void testaRemovePelaPlaca() {
Mockito.when(entityManager.getTransaction()).thenReturn(entityTransaction);
		
		CarroDAO cd2 = new CarroDAO();
		cd2.setEntityManager(entityManager);
		Carro c = new Carro("jetta", "qwe1224", "preto", 2015, 30);
		cd2.removerCarroPelaPlaca(c.getPlaca());
		
		Mockito.verify(entityManager).remove(Mockito.any(Carro.class));
        Mockito.verify(entityManager).close();
        Mockito.verify(entityTransaction).begin();
        Mockito.verify(entityTransaction).commit();
	}

}
