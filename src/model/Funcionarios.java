package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe de funcionario
 * @author Vinícius Santos
 *
 */
public abstract class Funcionarios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo = 0;
	private String nome; 
	private String telefones; 
	private String email;
	private Date dataCad;
	
	public Funcionarios() {
		
	}
	
	//Construtor sobrecarregado da classe incrementando o codigo do funcinario 
	public Funcionarios(String nome, String telefones, String email, Date dataCad) {
		this.codigo = this.codigo++;
		this.nome = nome;
		this.telefones = telefones;
		this.email = email;
		this.dataCad = dataCad;
	}


	public int compareTo(Funcionarios outroFuncionario) {
		if (this.nome == outroFuncionario.nome) {
			return 0;
		}
		else return -1;
		
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", telefones=" + telefones + ", email=" + email
				+ ", dataCad=" + dataCad + "]";
	}  
	
	
	
}


