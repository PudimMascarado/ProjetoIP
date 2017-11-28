package LivrosException;

public class DDException extends Exception{
	
	private String description;
	
	public DDException(String description) {
		super("Descrição diferente !!");
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
