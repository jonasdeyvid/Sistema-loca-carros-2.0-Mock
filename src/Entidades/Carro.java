package Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(unique = true)
	private String placa ;
	
	private String modelo;
	private String cor;
	private int ano;
	private double precoAluguel;
	private boolean alugado;
	public Carro() {
		
	}

	public Carro(String modelo, String placa, String cor, int ano, double precoAluguel) {
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.precoAluguel = precoAluguel;
		this.alugado = false;
	}
	

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(double precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

	@Override
	public String toString() {
		return "modelo=" + modelo + ", placa=" + placa + ", cor=" + cor + ", ano=" + ano + ", precoAluguel="
				+ precoAluguel + ", alugado=" + alugado + "\n";
	}
	
	
	
}
