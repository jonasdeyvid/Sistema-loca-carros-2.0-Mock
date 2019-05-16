package testes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import Controles.ControladorCliente;
import DAOS.ClienteDAO;
import Entidades.Carro;
import Entidades.Cliente;
public class ClienteDAOTeste {
	@Mock
    private Cliente cliente;
    @Mock
	private ClienteDAO clienteDAO;
    @Mock
    private EntityManager entityManager;
	@Mock
	Query query = Mockito.mock(Query.class);
	
	@Before
	public void setUp() throws Exception {
        cliente = new Cliente("Gui", "ararar", 12345678, "06115974388");
        entityManager = Mockito.mock(EntityManager.class);
        EntityManagerFactory entityManagerFactory = Mockito.mock(EntityManagerFactory.class);
        Mockito.when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        clienteDAO = new ClienteDAO(entityManagerFactory);

	}
	

	@Test
    public void addClienteTeste() {
        EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);

        clienteDAO.addCliente(cliente);

        Mockito.verify(entityManager).persist(cliente);
        Mockito.verify(entityManager).close();
        Mockito.verify(transaction).begin();
        Mockito.verify(transaction).commit();
    }
	
	@Test
	public void removerClienteTeste() {
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
	public void editarClienteTeste() {
		EntityTransaction transaction = Mockito.mock(EntityTransaction.class);
        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
       // Cliente cliente = new Cliente("Gui", "ararar", 12345678, "06115974388");

        clienteDAO.editarCliente("06115974388", "EudasioBarroso");
        
        Mockito.verify(entityManager).merge("Eudasioso");
        Mockito.verify(entityManager).close();
        Mockito.verify(transaction).begin();
        Mockito.verify(transaction).commit();
        assertNotNull(transaction);
	}
	
	@Test
	public void testeListar() {
		
        List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente c1 = new Cliente("gol1", "qwe1234", 12458745, "012365474123");
		Cliente c2 = new Cliente("gol1", "qwe1234", 12458745, "012365474123");
		Cliente c3 = new Cliente("gol1", "qwe1234", 12458745, "012365474123");
		Cliente c4 = new Cliente("gol1", "qwe1234", 12458745, "012365474123");
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		Mockito.when(entityManager.createQuery(Mockito.startsWith("FROM " + Cliente.class.getName()))).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(clientes);
		assertEquals(query.getResultList().size(), 4);
        assertEquals(query.getResultList().get(0), c1);
	}
	@Test
	public void buscarTeste() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente c1 = new Cliente("gol1", "qwe1234", 12458745, "012365474123");
		Cliente c2 = new Cliente("agol1", "qwe1234", 12458745, "012365474123");
		Cliente c3 = new Cliente("gol1", "qwe1234", 12458745, "012365474123");
		Cliente c4 = new Cliente("gol1", "qwe1234", 12458745, "012365474123");
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		
		Mockito.when(clienteDAO.buscarCliente("012365474123")).thenReturn(c1);
		assertEquals(clienteDAO.buscarCliente("012365474123").getNome(), c1.getNome() );
		
	}
	
}





























