package model;

import java.util.Date;

/**
 * 
 * @author Vinícius Santos
 * classe filmeQuatroD 
 * date 14/10/17
 * email viniciussantosx3@gmail.com
 * 
 */
public class Sessao {

//Atributos
	private int hora;
	private SalaCinema salaCinema;
	private Filme filme;
	private Date dataInicio;
	private Date dataFim;
	private int ocupacao = 0;

//Contrutor padrão
	public Sessao() {
		
	}
	
//Contrutor padrão
	public Sessao(int hora, SalaCinema salaCinema, Filme filme, Date dataInicio, Date dataFim) {
		this.hora = hora;
		this.salaCinema = salaCinema;
		this.filme = filme;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
//Métodos gets and sets

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public SalaCinema getSalaCinema() {
		return salaCinema;
	}

	public void setSalaCinema(SalaCinema salaCinema) {
		this.salaCinema = salaCinema;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getOcupacao() {
		return ocupacao;
	}

	public void incrementaOcupacao() {
		System.out.println("Ocupacação incrementada. ");
		this.ocupacao = ocupacao + 1;
	}
	
//Validador de sessão
	public Boolean equals(Sessao objSessao) {
		if ((objSessao.hora == this.hora) && (objSessao.filme == this.filme) && (objSessao.salaCinema == this.salaCinema)) {
			return true;
		}
		return false;
		
	}

	@Override
	public String toString() {
		return "\nHorário de início: " + this.hora + "\nSala: " + this.salaCinema.getId()
		+ "\nFilme: " + this.filme.getTitulo() + "\nOcupação da sala: " + this.getOcupacao() + "\nData de início: " 
		+ this.dataInicio.toString() + "\nData de fim: " + this.dataFim.toString(); 
	}
	
	
}
