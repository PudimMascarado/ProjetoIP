package ProjetoPack;
import LivrosException.LNEException;
import LivrosException.LIException;
public class RepositorioLivroArray implements RepositorioLivros {

	private int tamanho = 100;
	private Livro[] array = new Livro[tamanho];
	//how many books have from one type on library
	private int[] arrayQ = new int[tamanho];
	private int index = 0;

	public void inserir(Livro livro) {
		boolean b = false;
		//just will add something just if doesn't exist any other book equal;
		for(int i = 0; i < index; i++) {
			if(array[i].getTitulo().equals(livro.getTitulo())) {
				if(array[i].getMagia().equals(livro.getMagia()) && array[i].getDescription().equals(livro.getDescription())) {
					b = true;
					arrayQ[i]+=1;
				} else {
				}
			}
		}
		if(!b) {
			if(index < tamanho) {
				array[index] = livro;
				arrayQ[index] = 1;
				index++;
			} else {
				tamanho = 2*tamanho;
				Livro[] arrayAux = new Livro[tamanho];
				int[] arrayQAux = new int[tamanho];
				for(int i = 0; i < index; i++) {
					arrayAux[i] = this.array[i];
					arrayQAux[i] = this.arrayQ[i];
				}
				this.array = arrayAux;
				this.arrayQ = arrayQAux;
			}
		}
	}
	public void remover(String titulo, int quant) throws LNEException {
		boolean achou = false;
		for(int i = 0; i < index && !achou; i++) {
			if(array[i].getTitulo().equals(titulo)) {
				arrayQ[i] = arrayQ[i] - quant;
				if(arrayQ[i] <= 0) {
					this.array[i] = this.array[index];
					this.array[index] = null;
					index-=1;
					achou = true;
				}
			}
		}
		if(!achou) {
			throw new LNEException();
		}
	}
	public int procurar(String titulo) throws LNEException {
		int resposta = 0;
		boolean achou = false;
		for(int i = 0; i < index; i++) {
			if(array[i].getTitulo().equals(titulo)) {
				resposta = arrayQ[i];
				achou = true;
			}
		}
		if(!achou)
			throw new LNEException();
		return resposta;
	}
	public void locacao(String titulo, int quant) throws LIException {
		for(int i = 0; i < index; i++) {
			if(array[i].getTitulo().equals(titulo)) {
				if((arrayQ[i] - quant) < 0) {
					throw new LIException(titulo, arrayQ[i]);
				} else {
					arrayQ[i] -= arrayQ[i] - quant;
				}
			}
		}
	}

}
