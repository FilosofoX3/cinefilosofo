package model;

import java.io.Serializable;
import java.util.Date;

public class Gerente extends Funcionarios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String senha;
	
	// construtor padrão da classe
	public Gerente() {
		
	}

	//Construtor da super com os atributos de Gerente
	public Gerente(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}
	
	

	public Gerente(String nome, String telefones, String email, Date dataCad,String usuario, String senha) {
		super(nome, telefones, email, dataCad);
		this.usuario = usuario;
		this.senha = senha;
	}

	public  String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
