package ProjetoPack;
import LivrosException.LNEException;
import LivrosException.LIException;
import LivrosException.DDException;
import LivrosException.MIException;
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

	public void inserir(Livro livro) throws MIException, DDException {
		boolean b = false;
		if(this.proximo != null) {
			if(this.livro.getTitulo().equals(livro.getTitulo())) {
				if(!(this.livro.getMagia().getMagia().equals(livro.getMagia().getMagia()))){
					throw new MIException(this.livro.getMagia().getMagia());
				} else if(!(this.livro.getDescription().equals(livro.getDescription()))) {
					throw new DDException(this.livro.getDescription());
				} else {
					quant++;
					b = true;
				}
			}
		} else if(!b) {
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
	public void remover(String titulo) throws LNEException {
		boolean achou = false;
		if(this.proximo != null) {
			if(this.livro.getTitulo().equals(titulo)) {
				this.quant = this.proximo.quant;
				this.livro = this.proximo.livro;
				this.status = this.proximo.status;
				this.proximo = this.proximo.proximo;
				achou = true;
			}
		}
		if(!achou) {
			throw new LNEException();
		}
	}
	public Livro procurar(String titulo) throws LNEException {
		Livro resposta = null;
		if(existe(titulo)) {
			if(this.proximo != null) {
				if(this.livro.getTitulo().equals(titulo)) {
					resposta = this.livro;
				} else {
					resposta = this.proximo.procurar(titulo);
				}
			}
		} else {
			throw new LNEException();			
		}
		return resposta;
	}
	public void locacao(String titulo, int quant) throws LIException, LNEException {
		if(existe(titulo)) {
		if(this.proximo != null) {
			if(this.livro.getTitulo().equals(titulo)) {
				if(this.quant < quant) {
					throw new LIException(titulo, this.quant);
				}
				this.quant-=quant;
			} else {
				this.proximo.locacao(titulo, quant);
			}
		}
		} else {
			throw new LNEException();
		}
	}
	public boolean existe(String titulo) {
		boolean achou = false;
		if(this.proximo != null) {
			if(this.livro.getTitulo().equals(titulo)) {
				achou = true;
			} else {
				this.proximo.existe(titulo);
			}
		}
		return achou;
	}
	public void atualizar(String titulo, Livro livro) throws LNEException {
		if(existe(titulo)) {
			if(this.proximo != null) {
				if(this.livro.getTitulo().equals(titulo)) {
					this.livro = livro;
				} else {
					this.proximo.atualizar(titulo, livro);
				}
			}
		} else {
			throw new LNEException();
		}
	}
}


