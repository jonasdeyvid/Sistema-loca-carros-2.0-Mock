package testes;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import Controles.ControladorCarro;
import Controles.ControladorCliente;
import Entidades.Carro;
import Entidades.Cliente;

class SuiteDeTestes {

	
	//testes de cliente
	//adicao
	@Test
	public void testaAdicaoDeCliente() {
		String nome = "joao";
		String endereco = "Quixada CE";
		int contato = 92054322;
		String cpf = "12345612311";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(true, retorno);
	}

	@Test
	public void adicionarClienteComNomeNulo() {
		String nome = null;
		String endereco = "Quixada, CE";
		int contato = 92054322;
		String cpf = "12345612312";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}

	@Test
	public void adicionarClienteComNomeVazio() {
		String nome = "";
		String endereco = "Quixada, CE";
		int contato = 92054322;
		String cpf = "12345612313";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComNomeDeEspacos() {
		String nome = "     ";
		String endereco = "Quixada, CE";
		int contato = 92054322;
		String cpf = "12345612314";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoNulo() {
		String nome = "joao";
		String endereco = null;
		int contato = 92054322;
		String cpf = "12345612315";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoVazio() {
		String nome = "joao";
		String endereco = "";
		int contato = 92054322;
		String cpf = "12345612316";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoComEspeciais() {
		String nome = "joao";
		String endereco = "@-ç";
		int contato = 92054322;
		String cpf = "12345612317";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoComBarraN() {
		String nome = "joao";
		String endereco = "\n";
		int contato = 92054322;
		String cpf = "12345612318";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComContatoDeUmDigito() {
		String nome = "joao";
		String endereco = "Quixada, CE";
		int contato = 9;
		String cpf = "12345612319";
		boolean retorno = ControladorCliente.getInstance().addCliente(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}

	//busca
	@Test
	public void buscarClienteCpfValido(){
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", "Quixada, CE", 12345678, cpfCliente);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals("joao", c.getNome());
	}
	
	@Test
	public void buscarClienteCpfNulo() {
		Cliente c = ControladorCliente.getInstance().buscarCliente(null);
		assertEquals(null, c);
	}
	
	@Test
	public void buscarClienteCpfVazio() {
		Cliente c = ControladorCliente.getInstance().buscarCliente("");
		assertEquals(null, c);
	}
	
	@Test
	public void buscarClienteCaracteresEspeciais() {
		Cliente c = ControladorCliente.getInstance().buscarCliente("@Çç#_  _+-\\n");
		assertEquals(null, c);
	}
	
	//remocao
	@Test
	public void removerClienteCpfValido() {
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", "Quixada, CE", 12345678, cpfCliente);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals("joao", c.getNome());
		boolean retorno = ControladorCliente.getInstance().removerCliente(cpfCliente);
		assertEquals(true, retorno);
		retorno = ControladorCliente.getInstance().removerCliente(cpfCliente);
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerClienteCpfNulo() {
		boolean retorno = ControladorCliente.getInstance().removerCliente(null);
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerClienteCpfVazio() {
		boolean retorno = ControladorCliente.getInstance().removerCliente("");
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerClienteCaracteresEspeciais() {
		boolean retorno = ControladorCliente.getInstance().removerCliente("@Çç#_  _+-\n");
		assertEquals(false, retorno);
	}
	
	//edicao
	@Test
	public void editarClienteValido() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", "Quixada, CE", 12345678, cpfCliente);
		ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(enderecoNovo, c.getEndereco());
	}
	
	@Test
	public void editarClienteCpfNulo() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = null;
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteCpfVazio() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "";
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteCpfEspecial() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "ç\n_-!@#$%¨";
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteEnderecoValido() {
		String enderecoNovo = "Fortaleza, CE";
		String enderecoAntigo = "Quixada, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", enderecoAntigo, 12345678, cpfCliente);
		ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(enderecoNovo, c.getEndereco());
	}
	
	@Test
	public void editarClienteEnderecoNulo() {
		String enderecoNovo = null;
		String enderecoAntigo = "Quixada, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", enderecoAntigo, 12345678, cpfCliente);
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(false, retorno);
		assertEquals(enderecoAntigo, c.getEndereco());
	}
	
	@Test
	public void editarClienteEnderecoVazio() {
		String enderecoNovo = "";
		String enderecoAntigo = "Quixada, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", enderecoAntigo, 12345678, cpfCliente);
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(false, retorno);
		assertEquals(enderecoAntigo, c.getEndereco());
	}
	
	@Test
	public void editarClienteEnderecoEspecial() {
		String enderecoNovo = "ç\\n_-!@#$%¨";
		String enderecoAntigo = "Quixada, CE";
		String cpfCliente = "12345678911";
		ControladorCliente.getInstance().addCliente("joao", enderecoAntigo, 12345678, cpfCliente);
		boolean retorno = ControladorCliente.getInstance().editarCliente(cpfCliente, enderecoNovo);
		Cliente c = ControladorCliente.getInstance().buscarCliente(cpfCliente);
		assertEquals(false, retorno);
		assertEquals(enderecoAntigo, c.getEndereco());
	}
	
	//testes de carro
	//adicao
	@Test
	public void adicionarCarroValido() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(true, retorno);
		
	}
	
	@Test
	public void adicionarCarroModeloNulo() {
		String modelo = null;
		String placa = "hxa1234";
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarroModeloVazio() {
		String modelo = "";
		String placa = "hxa1234";
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarroModeloEspecial() {
		String modelo = "ç\\n_-!@#$%¨";
		String placa = "hxa1234";
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	
	@Test
	public void adicionarCarroPlacaNulo() {
		String modelo = "gol";
		String placa = null;
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarroPlacaVazio() {
		String modelo = "gol";
		String placa = "";
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarroPlacaEspecial() {
		String modelo = "gol";
		String placa = "ç\\\\n_-!@#$%¨";
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarroCorNula() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = null;
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarroCorVazio() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = "";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarroCorEspecial() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = "ç\\\\\\\\n_-!@#$%¨";
		int ano = 2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarroAnoNegativo() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = "branco";
		int ano = -2015;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
		
	}
	
	@Test
	public void adicionarCarroAnoSeguinteQueAindaNaoChegou() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = "branco";
		int ano = LocalDate.now().getYear() + 1;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
		
	}

	@Test
	public void adicionarCarroAnoAntesDaInvencaodoCarro1880() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = "branco";
		int ano = 1879;
		double precoAluguel = 120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
		
	}
	
	@Test
	public void adicionarCarroPrecoNegativo() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = -120;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
		
	}
	
	@Test
	public void adicionarCarroPrecoMenorInteiro() {
		String modelo = "gol";
		String placa = "hxa1234";
		String cor = "branco";
		int ano = 2015;
		double precoAluguel = Integer.MIN_VALUE;
		
		boolean retorno = ControladorCarro.getInstance().addCarro(modelo, placa, cor, ano, precoAluguel);
		assertEquals(false, retorno);
		
	}
	
	//remocao
	@Test
	public void removerCarroValido() {
		adicionarCarroValido();
		boolean retorno = ControladorCarro.getInstance().removerCarro("hxa1234");
		assertEquals(true, retorno);
	}
	
	@Test
	public void removerCarroPlacaNula() {
		adicionarCarroValido();
		try {
			ControladorCarro.getInstance().removerCarro(null);
		}catch (IllegalArgumentException ex) {
			assertEquals("placa nao pode ser nula", ex.getMessage());
		}
	}
	
	@Test
	public void removerCarroPlacaVazia() {
		adicionarCarroValido();
		boolean retorno = ControladorCarro.getInstance().removerCarro("");
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerCarroPlacaEspecial() {
		adicionarCarroValido();
		boolean retorno = ControladorCarro.getInstance().removerCarro("Ç/n//!@#%$%&");
		assertEquals(false, retorno);
	}
	//busca
	@Test
	public void buscarCarroValido() {
		adicionarCarroValido();
		Carro c = ControladorCarro.getInstance().buscarCarro("hxa1234");
		assertEquals("gol", c.getModelo());
	}
	
	@Test
	public void buscarCarroPlacaNula() {
		adicionarCarroValido();
		Carro c = ControladorCarro.getInstance().buscarCarro(null);
		assertEquals(null, c);
	}
	
	@Test
	public void buscarCarroInexistente() {
		adicionarCarroValido();
		Carro c = ControladorCarro.getInstance().buscarCarro("hxa1235");
		assertEquals(null, c);
	}
	
	
	//edicao
	@Test
	public void editarPrecoCarroValido() {
		adicionarCarroValido();
		boolean retorno = ControladorCarro.getInstance().editarPrecoCarro("hxa1234", 200);
		Carro c = ControladorCarro.getInstance().buscarCarro("hxa1234");
		assertEquals(true, retorno);
		assertEquals(true, c.getPrecoAluguel() == 200);
	}
	
	@Test
	public void editarCarroPrecoNegativo() {
		adicionarCarroValido();
		boolean retorno = ControladorCarro.getInstance().editarPrecoCarro("hxa1234", -200);
		Carro c = ControladorCarro.getInstance().buscarCarro("hxa1234");
		assertEquals(false, retorno);
		assertEquals(true, c.getPrecoAluguel() == 120);
	}
	
	//aluguel de carro
	@Test
	public void alugarCarroValido() {
		adicionarCarroValido();
		boolean retorno = ControladorCarro.getInstance().alugarCarro("hxa1234");
		assertEquals(true, retorno);
	}
	
	@Test
	public void alugarCarroJaALugado() {
		adicionarCarroValido();
		ControladorCarro.getInstance().alugarCarro("hxa1234");
		boolean retorno = ControladorCarro.getInstance().alugarCarro("hxa1234");
		assertEquals(false, retorno);
	}
	
	@Test
	public void alugarCarroInexistente() {
		adicionarCarroValido();
		boolean retorno = ControladorCarro.getInstance().alugarCarro("hxa1235");
		assertEquals(false, retorno);
	}
	
	@Test
	public void alugarCarroPlacaNula() {
		boolean retorno = ControladorCarro.getInstance().alugarCarro(null);
		assertEquals(false, retorno);
	}
	
	//devolucao de carro
	@Test
	public void devolverCarroValido() {
		alugarCarroValido();
		boolean retorno = ControladorCarro.getInstance().devolverCarro("hxa1234");
		assertEquals(true, retorno);
		Carro c = ControladorCarro.getInstance().buscarCarro("hxa1234");
		assertEquals(false, c.isAlugado());
	}
	
}
