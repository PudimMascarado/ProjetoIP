package LivrosException;

public class LIException extends Exception {
	
	private String titulo;
	private int quant;
	public LIException(String titulo, int quant) {
		super ("Locação indisponivel");
		this.titulo = titulo;
		this.quant = quant;
	}
	public String getMessage() {
		return "Locação indisponível";
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
}
