package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;
import entidades.Endereco;
import entidades.Funcionario;
import entidades.Telefone;

@ManagedBean(name = "FuncionarioBean")
@SessionScoped

public class FuncionarioBean {


	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String matricula;
	private String logradouro;
	private Integer numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private Integer ddd;
	private Integer numero_tel;
	private String tipo;
	
	
	
	private List<Funcionario> listaFuncionario;
	private List<Funcionario> listaFuncionario2;
	private Funcionario funcionario; 
	private FuncionarioDAO funcionarioDAO;
	//private List<Telefone> listaTelefone;
	//private Telefone telefone;

	
 	public FuncionarioBean() {
		this.listaFuncionario = new ArrayList<Funcionario>();
		this.funcionario = new Funcionario();
		this.funcionarioDAO = new FuncionarioDAOImpl();
		this.listaFuncionario2 = new ArrayList<Funcionario>();
		
	}


	public String entrar() {

		boolean achou = false;
		
		this.listaFuncionario = this.funcionarioDAO.listarTodos();
		
		for (Funcionario funcionarioPesquisa : listaFuncionario) {

			if (funcionarioPesquisa.getEmail().equals(this.email) && funcionarioPesquisa.getSenha().equals(this.senha)) {

				achou = true;
			}
		}

		if (achou) {
			return "Funcionarios.xhtml";
		} else {
			return "Usuário ou senha inválido";
		}

	}

	public void CadastrarFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setEmail(email);
		funcionario.setNome(nome);
		funcionario.setSenha(senha);
		funcionario.setCpf(cpf);
		funcionario.setMatricula(matricula);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setCep(cep);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setPais(pais);				
		funcionario.setEndereco(endereco);
		
		Telefone telefone = new Telefone();
		telefone.setDdd(ddd);
		telefone.setNumero_tel(numero_tel);
		telefone.setTipo(tipo);
		funcionario.setTelefone(telefone);
		
		boolean achou = false;
		
		this.listaFuncionario = this.funcionarioDAO.listarTodos();
		
		
		for (Funcionario funcionarioPesquisa : listaFuncionario) {
			if (funcionarioPesquisa.getNome().equals(this.funcionario.getNome())) {
				achou = true;
			}
		}
		
		if(achou == true) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Funcionário já existe!!!"));
		}else {
			this.funcionarioDAO.inserir(funcionario);
			this.funcionario = new Funcionario();	
		}
		
	
		
		}
		
		
		
	
	public void ExcluirFuncionario() {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCpf(cpf);
		
		boolean achou = false;
		
		this.listaFuncionario = this.funcionarioDAO.listarTodos();
		
		for (Funcionario funcionarioPesquisa : listaFuncionario) {
			if (funcionarioPesquisa.getCpf().equals(this.getCpf())) {
				achou = true;
			}
		}		
		if(achou == true) {
			this.funcionarioDAO.remover(funcionario);
			this.funcionario = new Funcionario();
			
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Funcionário não existe!!!"));
		}
	}
	
	
	public void AlterarFuncionario() {
				
		funcionario.setCpf(cpf);
		
		boolean achou = false;
		
		this.listaFuncionario = this.funcionarioDAO.listarTodos();
		
		for (Funcionario funcionarioPesquisa : listaFuncionario) {
			if (funcionarioPesquisa.getCpf().equals(cpf)) {
				achou = true;
			}
		}		
		if(achou == true) {
			 this.funcionarioDAO.alterar(funcionario);
			
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Funcionário não existe!!!"));
		}
	}
	
	
	
	public void  PesquisarFuncionario() {
		
		funcionario.setCpf(cpf);
		
		boolean achou = false;
		
		this.listaFuncionario = this.funcionarioDAO.listarTodos();
		
		for (Funcionario funcionarioPesquisa : listaFuncionario) {
			if (funcionarioPesquisa.getCpf().equals(cpf)) {
				achou = true;
			}
		}		
		if(achou == true) {
			funcionario = this.funcionarioDAO.pesquisar(funcionario);
			
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario não existe!!!"));
		}
	} 
	
		
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
		
	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getDdd() {
		return ddd;
	}


	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}


	public Integer getNumero_tel() {
		return numero_tel;
	}


	public void setNumero_tel(Integer numero_tel) {
		this.numero_tel = numero_tel;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	
	

	public List<Funcionario> getListaFuncionario2() {
		return listaFuncionario2;
	}


	public void setListaFuncionario2(List<Funcionario> listaFuncionario2) {
		this.listaFuncionario2 = listaFuncionario2;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	
}

