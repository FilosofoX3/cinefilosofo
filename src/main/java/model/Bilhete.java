package model;

/**
 * 
 * @author Vinícius Santos
 * classe filmeQuatroD 
 * date 14/10/17
 * email viniciussantosx3@gmail.com
 * 
 */
public class Bilhete {

//Atributos
	private int cont = 0;
	private int numBilhete = 0;
	private Sessao sessao;
	private double valor;
	private String cliente;
	private String cpf;

// contrutor padrão
	public Bilhete() {
		
	}
	
// contrutor padrão
	public Bilhete(Sessao sessao, double valor, String cliente, String cpf) {
	this.sessao = sessao;
	this.valor = valor;
	this.cliente = cliente;
	this.cpf = cpf;
	incrementaBilhete();
	this.cont = this.cont++;
}

	public void setNumBilhete(int numBilhete) {
		this.numBilhete = numBilhete;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public  int getCont() {
		return cont;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getNumBilhete() {
		return numBilhete;
	}
	
	public Sessao getSessao() {
		return sessao;
	}
	
	public double getValor() {
		return valor;
	}
	public void incrementaBilhete() {
		System.out.println("Incrementou !!!!!!");
		this.numBilhete = numBilhete + 1;
	}
	
    @Override
	public String toString() {
		return "\nNúmero do bilhete: " +(this.getNumBilhete() + cont) + "\nCliente:" + getCliente() + "\nCPF: " + getCpf()  + "\nSessao das: " + 
		this.sessao.getHora() +" Horas" +  "\nValor de compra:R$ " + this.valor + "\n";
	}	
		
	
}
