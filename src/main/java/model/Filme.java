package model;

/**
 * 
 * @author Vinícius Santos classe filme date 14/10/17 email
 *         viniciussantosx3@gmail.com
 * 
 */

//Atributos
public abstract class Filme {
	private String titulo;
	private int duracao; // em minutos
	private int anoLancamento;
	private int classificacao;
	private String genero;

//Construtor padrao 
	public Filme() {

	}

//Construtor padrao com parâmetros
	public Filme(String titulo, int duracao, int anoLancamento, int classificacao, String genero) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		this.anoLancamento = anoLancamento;
		this.classificacao = classificacao;
		this.genero = genero;
	}



	//Métodos gets and sets
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Filme: " + titulo + "\nduracao= " + duracao + "\nanoLancamento= " + anoLancamento
				+ "\nclassificacao= " + classificacao + ", \ngenero= " + genero ;
	}

}
