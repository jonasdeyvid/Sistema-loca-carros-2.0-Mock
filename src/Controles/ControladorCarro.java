package Controles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAOS.CarroDAO;
import Entidades.Carro;

public class ControladorCarro {
	private static ControladorCarro controler;
	private CarroDAO carroDAO = new CarroDAO();
	private ControladorCarro() {
		
	}
	
	public static ControladorCarro getInstance() {
		if(controler == null ) {
			return new ControladorCarro();
		}
		return controler;
	}
	
	public boolean addCarro(String modelo, String placa, String cor, int ano, double precoAluguel) {
		if(modelo ==  null || modelo.equals(""))  return false ; 
		if(!(modelo.substring(0, 3).matches("[A-Z a-z]*")) )return false;
		if(placa ==  null)  return false;
		if(placa.equals("")) return false;
		if(!(placa.substring(0, 3).matches("[A-Z a-z]*")) )return false;
		if(placa.equals("")) return false;
		if(cor ==  null)  return false;
		if(cor.equals("")) return false;
		if(!(cor.substring(0, 3).matches("[A-Z a-z]*")) )return false;
		if(ano > LocalDate.now().getYear() || ano < 1880) return false; // tem que melhorar isso aqui 
		if(precoAluguel <= 0) return false;
		
		Carro carro = new Carro(modelo, placa, cor, ano, precoAluguel);
		carroDAO.addCarro(carro);
		return true;
	}
	
	public boolean removerCarro(String placa) {
		if(placa ==  null)  throw new IllegalArgumentException("placa nao pode ser nula");
		if(carroDAO.removerCarro(placa)) {
			return true;
		}
		return false;
	}
	
	public boolean editarPrecoCarro(String placa, double novoPreco) {
		if(novoPreco < 0) return false;
		if(carroDAO.editarPrecoCarro(placa, novoPreco)){
			return true;
		}
		return false;
	}
	
	public List<Carro> carrosDisponiveis(){
		return carroDAO.carrosDisponiveis();
	}
	public boolean alugarCarro(String placa) {
		Carro carro = carroDAO.buscarCarro(placa);
			if(carro != null && carro.isAlugado() == false){
				carro.setAlugado(true);
				carroDAO.setCarroAlugado(carro);
				return true;
			
		}
		return false;
	}
	public boolean devolverCarro(String placa) {
		for (Carro carro : carroDAO.getCarros()) {
			if(carro.getPlaca().equals(placa)) {
				if(carro.isAlugado() == true) {
					carro.setAlugado(false);
					return true;
				}
			}
			
		}
		return false;
	}
	public Carro buscarCarro(String placa) {
		return carroDAO.buscarCarro(placa);
	}
	
	public List<Carro> getCarros(){
		return carroDAO.getCarros();
	}
	
	
}
