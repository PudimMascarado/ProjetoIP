package ProjetoPack;
import LivrosException.LNEException;
import LivrosException.LIException;
import LivrosException.MIException;
import LivrosException.DDException;
public class RepositorioLivroArray implements RepositorioLivros {

	private int tamanho;
	private Livro[] array;
	//how many books have from one type on library
	private int[] arrayQ;
	private int index;
	
	public RepositorioLivroArray() {
		this.tamanho = 100;
		this.array = new Livro[tamanho];
		this.arrayQ = new int[tamanho];
		this.index = 0;
	}

	public void inserir(Livro livro) throws MIException, DDException {
		boolean b = false;
		//just will add something just if doesn't exist any other book equal;
		for(int i = 0; i < index; i++) {
			if(array[i].getTitulo().equals(livro.getTitulo())) {
				if(!(array[i].getMagia().getMagia().equals(livro.getMagia().getMagia()))) {
					throw new MIException(array[i].getMagia().getMagia());
				} else if(!(array[i].getDescription().equals(livro.getDescription()))) {
					throw new DDException(array[i].getDescription());
				} else {
					b = true;
					arrayQ[i]+=1;
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
				array[index] = livro;
				arrayQ[index] = 1;
				index++;
			}
		}
	}
	public void remover(String titulo) throws LNEException {
		boolean achou = false;
		for(int i = 0;!achou && i < index; i++) {
			if(array[i].getTitulo().equals(titulo)) {
				this.array[i] = this.array[index];
				this.arrayQ[i] = this.arrayQ[index];
				this.array[index] = null;
				index-=1;
				achou = true;
			}
		}
		if(!achou) {
			throw new LNEException();
		}
	}
	public Livro procurar(String titulo) throws LNEException {
		Livro resposta = null;
		boolean achou = false;
		for(int i = 0; i < index; i++) {
			if(array[i].getTitulo().equals(titulo)) {
				resposta = array[i];
				achou = true;
			}
		}
		if(!achou)
			throw new LNEException();
		return resposta;
	}
	public void locacao(String titulo, int quant) throws LIException, LNEException {
		if(existe(titulo)){
		for(int i = 0; i < index; i++) {
			if(array[i].getTitulo().equals(titulo)) {
				if((arrayQ[i] - quant) < 0) {
					throw new LIException(titulo, arrayQ[i]);
				} else {
					arrayQ[i] = arrayQ[i] - quant;
				}
			}
		}
		} else {
			throw new LNEException();
		}
	}
	public boolean existe(String titulo) {
		boolean achou = false;
		for(int i = 0; i < index; i++) {
			if(array[i].getTitulo().equals(titulo)) {
				achou = true;
			}
		}
		return achou;
	}
	public void atualizar(String titulo, Livro livro) throws LNEException{
		boolean b = false;
		if(existe(titulo)) {
			for(int i = 0;!b && i < index; i++) {
				if(array[i].getTitulo().equals(titulo)) {
					this.array[i] = livro;
					b = true;
				}
			}
		} else {
			throw new LNEException();
		}
	}
}
