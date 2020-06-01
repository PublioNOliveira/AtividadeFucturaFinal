package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.TelefoneDAO;
import dao.TelefoneDAOImpl;
import entidades.Telefone;

@ManagedBean(name = "TelefoneBean")
@SessionScoped

public class TelefoneBean {

	private Integer ddd;
	private Integer numero_tel;
	private String tipo;
	private String cpf_func;
		
	private List<Telefone> listaTelefone;
	private Telefone telefone; 
	private TelefoneDAO telefoneDAO;

	
	public TelefoneBean() {
		this.listaTelefone = new ArrayList<Telefone>();
		this.telefone = new Telefone();
		this.telefoneDAO = new TelefoneDAOImpl();
	}


	public String entrar() {

		boolean achou = false;
		
		this.listaTelefone = this.telefoneDAO.listarTodos();
		
		for (Telefone telefonePesquisa : listaTelefone) {

			if (telefonePesquisa.getDdd().equals(this.numero_tel) && telefonePesquisa.getDdd().equals(this.numero_tel)) {

				achou = true;
			}
		}

		if (achou) {
			return "telefone.xhtml";
		} else {
			return "telefone ou senha inválido";
		}

	}

	public void CadastrarTelefone() {
		Telefone telefone = new Telefone();
		
		telefone.setDdd(ddd);
		telefone.setNumero_tel(numero_tel);
		telefone.setTipo(tipo);
		telefone.setCpf_func(cpf_func);
		boolean achou = false;
		
		this.listaTelefone = this.telefoneDAO.listarTodos();
		
		for (Telefone telefonePesquisa : listaTelefone) {
			if (telefonePesquisa.getNumero_tel().equals(this.telefone.getNumero_tel())) {
				achou = true;
			}
		}
		
		if(achou == true) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Telefone já existe!!!"));
		}else {
			this.telefoneDAO.inserir(telefone);
			this.telefone = new Telefone();	
		}
		}
	
	public void ExcluirTelefone() {
		Telefone telefone = new Telefone();
		
		telefone.setNumero_tel(numero_tel);
		
		boolean achou = false;
		
		this.listaTelefone = this.telefoneDAO.listarTodos();
		
		for (Telefone telefonePesquisa : listaTelefone) {
			if (telefonePesquisa.getNumero_tel().equals(this.getNumero_tel())) {
				achou = true;
			}
		}		
		if(achou == true) {
			this.telefoneDAO.remover(telefone);
			this.telefone = new Telefone();
			
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Telefone não existe!!!"));
		}
	}
	
	
	public void AlterarTelefone() {

 		telefone.setNumero_tel(numero_tel);
		
		boolean achou = false;
		
		this.listaTelefone = this.telefoneDAO.listarTodos();
		
		for (Telefone telefonePesquisa : listaTelefone) {
			if (telefonePesquisa.getNumero_tel().equals(numero_tel)) {
				achou = true;
			}
		}		
		if(achou == true) {
			 this.telefoneDAO.alterar(telefone);
			
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Telefone não existe!!!"));
		}
	}
	
	
	
	public void PesquisarTelefone() {
		
		telefone.setNumero_tel(numero_tel);
		
		boolean achou = false;
		
		this.listaTelefone = this.telefoneDAO.listarTodos();
		
		for (Telefone telefonePesquisa : listaTelefone) {
			if (telefonePesquisa.getNumero_tel().equals(numero_tel)) {
				achou = true;
			}
		}		
		if(achou == true) {
			telefone = this.telefoneDAO.pesquisar(telefone);
			
		}else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario não existe!!!"));
		}
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

	public String getCpf_func() {
		return cpf_func;
	}


	public void setCpf_func(String cpf_func) {
		this.cpf_func = cpf_func;
	}


	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}


}

