package dao;

import java.util.List;

import entidades.Funcionario;

public interface FuncionarioDAO {

	public void inserir(Funcionario funcionario);
	
	public void alterar(Funcionario funcionario);

	public void remover(Funcionario funcionario);

	public Funcionario pesquisar(Funcionario funcionario);

	public List<Funcionario> listarTodos();
	
	}
