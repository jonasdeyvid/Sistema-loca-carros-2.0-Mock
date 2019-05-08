package dao;

import Entidades.Cliente;

public interface ClienteDAO {
	public Cliente getClienteByCpf(String cpf);
}
