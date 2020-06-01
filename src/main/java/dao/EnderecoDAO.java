package dao;

import java.util.List;
import entidades.Endereco;


public interface EnderecoDAO {

	public void inserir(Endereco endereco);

	public void alterar(Endereco endereco);

	public void remover(Endereco endereco);

	public Endereco pesquisar(String cep);

	public List<Endereco> listarTodos();

}
