package LivrosException;
public class MIException extends Exception {
	
	private String magia;
	
	public MIException(String magia) {
		super("Magias diferentes !!");
		this.magia = magia;
	}

	public String getMagia() {
		return magia;
	}

	public void setMagia(String magia) {
		this.magia = magia;
	}
	
}
