package ProjetoPack;
import LivrosException.LNEException;
import LivrosException.LIException;
import LivrosException.DDException;
import LivrosException.MIException;
public interface RepositorioLivros {
      void inserir(Livro livro) throws MIException, DDException;
      void remover(String titulo) throws LNEException;
      //return how much books you have;
      Livro procurar(String titulo) throws LNEException;
      void locacao(String titulo, int quant) throws LIException, LNEException;
      boolean existe(String titulo);
      void atualizar(String titulo, Livro livro) throws LNEException;
}
