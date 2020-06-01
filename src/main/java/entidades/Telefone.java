package entidades;

public class Telefone {
	private Integer ddd;
	private Integer numero_tel;
	private String tipo;
	private String cpf_func;
	
	public Telefone() {
	}

	public Telefone(Integer ddd, Integer numero_tel, String tipo, String cpf_func) {
		this.ddd = ddd;
		this.numero_tel = numero_tel;
		this.tipo = tipo;
		this.cpf_func = cpf_func;
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
	
}