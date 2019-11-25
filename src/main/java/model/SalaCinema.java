package model;

/**
 * 
 * @author Vinícius Santos
 * classe filmeQuatroD 
 * date 14/10/17
 * email viniciussantosx3@gmail.com
 * 
 */
public class SalaCinema {
	
//Atributos
	private int id;
	private final int capacidade;
	private boolean quatroD;
	
//Construtor padrão com parâmetros
	public SalaCinema(int id, int capacidade, boolean quatroD) {
		this.id = id;
		this.capacidade = capacidade;
		this.quatroD = quatroD;
	}

//Métodos gets and sets
	public  int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isQuatroD() {
		return quatroD;
	}

	public void setQuatroD(boolean quatroD) {
		this.quatroD = quatroD;
	}
	
	public boolean getQuatroD() {
		return quatroD;
	}

	public int getCapacidade() {
		return capacidade;
	}

	@Override
	public String toString() {
		String tecnologia;
		if (this.quatroD) {
			tecnologia = "4D";
		}
		else {
			tecnologia = "3D";
		}
		return "\nIdentificador: " + this.id+ "\nCapacidade: " + capacidade 
		 + "\nA tecnologia da sala eh para filmes: " +  tecnologia + "\n";
	}
}
