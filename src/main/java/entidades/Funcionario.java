package entidades;

import java.util.ArrayList;

public class Funcionario {
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String matricula;
	private Telefone telefone;
	private Endereco endereco;
	private ArrayList<Telefone> listaTelefone = new ArrayList<>();
	
	
	public Funcionario() {
		}
	
		
	public Funcionario(String nome, String email, String senha, String cpf, String matricula, Telefone telefone,
			Endereco endereco, ArrayList<Telefone> listaTelefone) {
		
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.matricula = matricula;
		this.telefone = telefone;
		this.endereco = endereco;
		this.listaTelefone = listaTelefone;
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
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public ArrayList<Telefone> getListaTelefone() {
		return listaTelefone;
	}


	public void setListaTelefone(ArrayList<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}


	

	

	
}
