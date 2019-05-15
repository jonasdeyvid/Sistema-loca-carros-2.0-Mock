package testes;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import DAOS.ClienteDAO;
import Entidades.Cliente;
public class ClienteDAOTeste {
    private Cliente cliente;
    private ClienteDAO clienteDAO;
    private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
        cliente = new Cliente("Gui", "ararar", 12345678, "06115974388");
        entityManager = Mockito.mock(EntityManager.class);
        EntityManagerFactory entityManagerFactory = Mockito.mock(EntityManagerFactory.class);
        Mockito.when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        clienteDAO = new ClienteDAO(entityManagerFactory);

	}
	

	@Test
    public void addCliente() {
        EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);

        clienteDAO.addCliente(cliente);

        Mockito.verify(entityManager).persist(cliente);
        Mockito.verify(entityManager).close();
        Mockito.verify(transaction).begin();
        Mockito.verify(transaction).commit();
    }
	
	@Test
	public void removerCliente() {
		EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);

        clienteDAO.removerCliente("06115974388");
        
        Mockito.verify(entityManager).remove("06115974388");
        Mockito.verify(entityManager).close();
        Mockito.verify(transaction).begin();
        Mockito.verify(transaction).commit();
        assertNotNull(transaction);
	}
	
	@Test
	public void editarCliente() {
		EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
       // Cliente cliente = new Cliente("Gui", "ararar", 12345678, "06115974388");

        clienteDAO.editarCliente("06115974388", "EudasioBarroso");
        
        Mockito.verify(entityManager).merge("Eudasioso");
        Mockito.verify(entityManager).close();
        Mockito.verify(transaction).begin();
        Mockito.verify(transaction).commit();
       
	}
	
	
}





























