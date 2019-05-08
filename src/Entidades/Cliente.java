package Entidades;

public class Cliente {
	private String nome;
	private String endereco;
	private int contato;
	private String cpf;
	
	public Cliente() {
		
	}
	public Cliente(String nome, String endereco, int contato, String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getContato() {
		return contato;
	}
	public void setContato(int contato) {
		this.contato = contato;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "nome= " + nome + ", endereco= " + endereco + ", contato=" + contato + ", cpf=" + cpf ;
	}
}
