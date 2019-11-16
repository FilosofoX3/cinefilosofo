package model;
/**
 * 
 * @author Vin�cius Santos
 * classe filmeQuatroD 
 * date 14/10/17
 * email viniciussantosx3@gmail.com
 * 
 */
public class FilmeQuatroD extends Filme{
	
//Atributos
	public static final double valorPoltrona1 = 20;
	public static final double valorPoltrona2 = 30;//poltronaInteligente
	private boolean poltrona;

//Construtor padr�o
	public FilmeQuatroD() {
		
	}
	
//Construtor padr�o com par�metros da da sub e super classe
	public FilmeQuatroD(String titulo, int duracao, int anoLancamento, int classificacao, String genero, boolean poltrona) {
		super(titulo, duracao, anoLancamento, classificacao, genero);
		this.poltrona = poltrona;
	}

	@Override
	public String toString() {
		 return super.toString() + "\nTipo de poltrona: " + this.poltrona + "\n"; 
	}
	
	
	

	
	
	

}
