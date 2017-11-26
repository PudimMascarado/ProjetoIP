package ProjetoPack;
import LivrosException.LNEException;
import LivrosException.LIException;
public class RepositorioLivroLista implements RepositorioLivros {

	private Livro livro;
	private String status;
	//quantidade;
	private int quant;
	private RepositorioLivroLista proximo;

	public RepositorioLivroLista() {
		this.livro = null;
		this.status = null;
		this.proximo = null;
		this.quant = 0;
	}

	public void inserir(Livro livro) {
		if(this.proximo != null) {
			if(this.livro == livro) {
				quant++;
			}
		} else {
			if(this.proximo == null) {
				this.livro = livro;
				this.status = "available";
				this.quant = this.quant + 1;
				this.proximo = new RepositorioLivroLista();
			} else {
				this.proximo.inserir(livro);
			}
		}
	}
	public void remover(String titulo, int quant) throws LNEException {
		boolean achou = false;
		if(this.proximo != null) {
			if(this.livro.getTitulo().equals(titulo)) {
				this.quant = this.quant - quant;
				if(this.quant <= 0) {
					this.livro = this.proximo.livro;
					this.status = this.proximo.status;
					this.proximo = this.proximo.proximo;
					achou = true;
				}
			}
		}
		if(!achou) {
			throw new LNEException();
		}
	}
	public int procurar(String titulo) throws LNEException {
		boolean achou = false;
		int resposta = 0;
			if(this.proximo != null) {
				if(this.livro.equals(titulo)) {
					resposta = this.quant;
					achou = true;
				} else {
					resposta = this.proximo.procurar(titulo);
				}
			}
			if(!achou) {
				throw new LNEException();
			}
			return resposta;
		}		
	public void locacao(String titulo, int quant) throws LIException {
		if(this.proximo != null) {
			if(this.livro.getTitulo().equals(titulo)) {
				if(this.quant < quant) {
					throw new LIException(titulo, quant);
				}
				this.quant-=quant;
			} else {
				this.proximo.locacao(titulo, quant);
			}
		}
	}
}

 
