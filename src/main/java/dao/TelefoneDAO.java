package dao;

import java.util.List;

import entidades.Telefone;

public interface TelefoneDAO {

	public void inserir(Telefone telefone);

	public void alterar(Telefone telefone);

	public void remover(Telefone telefone);

	public Telefone pesquisar(Telefone telefone);

	public List<Telefone> listarTodos();
	
	

}
