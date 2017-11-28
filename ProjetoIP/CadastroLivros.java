package ProjetoPack;
import LivrosException.DDException;
import LivrosException.MIException;
import LivrosException.LNEException;
import LivrosException.LIException;
public class CadastroLivros {
	private RepositorioLivros livros;

	public CadastroLivros(RepositorioLivros rep) {
		livros = rep;
	}
	public void cadastrar(Livro livro) throws DDException, MIException {
		livros.inserir(livro);
	}
	public void remover(String titulo) throws LNEException {
		if(livros.existe(titulo)) {
			livros.remover(titulo);
		}
	}
	public Livro procurar(String titulo) throws LNEException {
		if(livros.existe(titulo)) {
			return livros.procurar(titulo);
		} else {
			throw new LNEException();
		}
	}
	public void locacao(String titulo, int quant) throws LIException, LNEException {
		if(livros.existe(titulo)) {
			livros.locacao(titulo, quant);
		} else {
			throw new LNEException();
		}
	}
	public boolean existe(String titulo) {
		return livros.existe(titulo);
	}
	public void atualizar(String titulo, Livro livro) throws LNEException{
		if(livros.existe(titulo)) {
			livros.atualizar(titulo, livro);
		} else {
			throw new LNEException();
		}
	}
}
