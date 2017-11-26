package ProjetoPack;

public class Elemental {
	String nomeElemental;
	String elemento;
	int idadeElemental;
	int grauElemental;
	double multiplicador;

	public Elemental(String nome, String elemento, int idade, int grau) {
		this.nomeElemental = nome;
		this.elemento = elemento;
		this.idadeElemental = Math.abs(idade);
		this.grauElemental = Math.abs(grau);
		this.multiplicador = Math.ceil((Math.sqrt(idade) / 5) * grau);
	}

	public String getNomeElemental() {
		return nomeElemental;
	}

	public void setNomeElemental(String nomeElemental) {
		this.nomeElemental = nomeElemental;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int getIdadeElemental() {
		return idadeElemental;
	}

	public void setIdadeElemental(int idadeElemental) {
		this.idadeElemental = idadeElemental;
	}

	public int getGrauElemental() {
		return grauElemental;
	}

	public void setGrauElemental(int grauElemental) {
		this.grauElemental = grauElemental;
	}

	public double getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}

}