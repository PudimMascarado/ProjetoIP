package LivrosException;

public class LIException extends Exception {
	
	private String titulo;
	private int quant;
	public LIException(String titulo, int quant) {
		super ("Loca��o indisponivel");
		this.titulo = titulo;
		this.quant = quant;
	}
	public String getMessage() {
		return "Loca��o indispon�vel";
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
