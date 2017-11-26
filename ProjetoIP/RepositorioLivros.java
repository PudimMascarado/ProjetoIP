package ProjetoPack;
import LivrosException.LNEException;
import LivrosException.LIException;
public interface RepositorioLivros {
      void inserir(Livro livro);
      void remover(String titulo, int quant) throws LNEException;
      //return how much books you have;
      int procurar(String titulo) throws LNEException;
      void locacao(String titulo, int quant) throws LIException;
}
