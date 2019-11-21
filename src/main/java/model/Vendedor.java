package model;

import java.io.Serializable;
import java.util.Date;

public class Vendedor extends Funcionarios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idUsuario;

	//Construtor padrão da classe
	public Vendedor() {
		
	}
	//Construtor da super com os atributos de Vendedor
	public Vendedor(String nome, String telefones, String email, Date dataCad, String idUsuario) {
		super(nome, telefones, email, dataCad);
		this.idUsuario = idUsuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
