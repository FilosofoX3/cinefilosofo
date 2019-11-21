package model;
/**
 * 
 * @author Vin�cius Santos
 * classe filmeQuatroD 
 * date 14/10/17
 * email viniciussantosx3@gmail.com
 * 
 */
public class FilmeTresD extends Filme {
	

   //Atributos
	public static final int valorOculos1 = 30; // tipo ativo 
    public static final int valorOculos2 = 20; // tipo passivo polarizado
    private boolean oculosAtivo;

   //Construtor padr�o
  	public FilmeTresD() {
  		
  	}
  	
    //Construtor padr�o com par�metros
    public FilmeTresD(String titulo, int duracao, int anoDeLancamento, int classificacaoIndicativa, String genero, boolean oculosAtivo) {
        super(titulo, duracao, anoDeLancamento, classificacaoIndicativa, genero);
        this.oculosAtivo = oculosAtivo;
    }

    public boolean getoculosAtivo() {
        return this.oculosAtivo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de �culos: " + this.oculosAtivo + "\n";
    }
}