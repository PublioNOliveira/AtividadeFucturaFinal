package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.EnderecoDAO;
import dao.EnderecoDAOImpl;
import entidades.Endereco;



@ManagedBean(name = "EnderecoBean")
@SessionScoped

public class EnderecoBean {


	private String logradouro;
	private int numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	
	
	private List<Endereco> listaEndereco;
	private Endereco endereco; 
	private EnderecoDAO enderecoDAO;

	
	public EnderecoBean() {
		this.listaEndereco = new ArrayList<Endereco>();
		this.endereco = new Endereco();
		this.enderecoDAO = new EnderecoDAOImpl();
	}


	

	public void CadastrarEndereco() {
		Endereco endereco = new Endereco();
				
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setCep(cep);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setPais(pais);		
		
		boolean achou = false;
		
		this.listaEndereco = this.enderecoDAO.listarTodos();
		
		for (Endereco enderecoPesquisa : listaEndereco) {
			if (enderecoPesquisa.getCep().equals(this.endereco.getCep())) {
				achou = true;
			}
		}
		
		if(achou == true) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Endereço já existe!!!"));
		}else {
			this.enderecoDAO.inserir(endereco);
			this.endereco = new Endereco();	
		}
		}
	
	
	
	public void ExcluirEndereco() {
		Endereco endereco = new Endereco();
		
		endereco.setCep(cep);
		
		boolean achou = false;
		
		this.listaEndereco = this.enderecoDAO.listarTodos();
		
		for (Endereco enderecoPesquisa : listaEndereco) {
			if (enderecoPesquisa.getCep().equals(this.getCep())) {
				achou = true;
			}
		}		
		if(achou == true) {
			this.enderecoDAO.remover(endereco);
			this.endereco = new Endereco();
			
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Endereço não existe!!!"));
		}
	}
	
	
	public void AlterarEndereco() {
		Endereco endereco = new Endereco();
		
		endereco.setCep(cep);
		
		boolean achou = false;
		
		this.listaEndereco = this.enderecoDAO.listarTodos();
		
		for (Endereco enderecoPesquisa : listaEndereco) {
			if (enderecoPesquisa.getCep().equals(this.endereco.getCep())) {
				achou = true;
			}
		}		
		if(achou == true) {
			this.enderecoDAO.alterar(endereco);
			this.endereco = new Endereco();
			
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Endereço não existe!!!"));
		}
	}
	
	
	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
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


	public List<Endereco> getListaEndereco() {
		return listaEndereco;
	}

	public void setListaEndereco(List<Endereco> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


}

