package ProjetoPack;
import java.util.Scanner;
import LivrosException.LIException;
import LivrosException.LNEException;
import LivrosException.DDException;
import LivrosException.MIException;
import java.io.*;
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String linha = null;
		CadastroLivros a = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader("c:/ProjetoOrdem.txt"));
			while(br.ready()){
				linha = br.readLine();
			}
			br.close();
			switch(linha) {
			case("Lista"):
				RepositorioLivroLista rep = new RepositorioLivroLista();
			a = new CadastroLivros(rep);
			break;
			case("Array"):
				RepositorioLivroArray repa = new RepositorioLivroArray();
			a = new CadastroLivros(repa);
			break;
			}
			String ordem = "inicio";
			while(!(ordem.equals("fim"))) {
				System.out.println("Escreve a ordem desejada. Se quiser terminar o programa escreva 'fim'.");
				ordem = in.nextLine();
				switch(ordem) {
				case("Cadastrar livro"):
					System.out.println("digite o titulo");
					String titulo = in.nextLine();
				String magias = "sim";
				ListaMagia b = new ListaMagia();
				while(!(magias.equals("nao"))) {
					System.out.println("Escreva o : Nome da magia, mana, poder total e poder necessario. Nessa ordem, por favor");
					Magia magia = new Magia(in.nextLine(), in.nextInt(), in.nextInt(), in.nextInt(), false);
					b.inserir(magia);
					System.out.println("Deseja continuar ?");
					magias = in.next();
				}
				System.out.println("Digite a descrição do livro.");
				in.next();
				String description = in.nextLine();
				Livro livro = new Livro(titulo, b, description);
				try{
					a.cadastrar(livro);
				} catch (MIException e) {
					System.out.println(e.getMessage());
				} catch (DDException e) {
					System.out.println(e.getMessage());
				}
				break;
				case("procurarLivro"):
					System.out.println("Qual titulo voce deseja procurar ?");
				String tituloProcurar = in.nextLine();
				try {
					System.out.println("Esse livro possui as seguintes caracteristicas:");
					System.out.print("Magias: ");
					System.out.println(a.procurar(tituloProcurar).getMagia().getMagia());
					System.out.print("Poder: ");
					System.out.println(a.procurar(tituloProcurar).getPoder());
					System.out.print("Descrição: ");
					System.out.println(a.procurar(tituloProcurar).getDescription());
				} catch (LNEException e) {
					System.out.println(e.getMessage());
				}
				break;
				case("Locar"):
					System.out.println("Qual livro deseja locar ?");
				String tituloLocar = in.nextLine();
				int quant = in.nextInt();
				in.next();
				try {
					a.locacao(tituloLocar, quant);
				} catch (LNEException e) {
					e.printStackTrace();
				} catch (LIException e) {
					System.out.println(e.getMessage());
					System.out.printf("Disponivel para %s: %d\n", e.getTitulo(), e.getQuant());
				}
				break;
				case("Atualizar"):
					System.out.println("Qual livro você deseja atualizar ?");
				String tituloatt = in.nextLine();
				System.out.println("Atualize-o completamente.");
				System.out.println("Digite seu novo titulo");
				String titulo2 = in.nextLine();
				String magias2 = "sim";
				ListaMagia b2 = new ListaMagia();
				while(!(magias2.equals("nao"))) {
					System.out.println("Escreva o : Nome da magia, mana, poder total e poder necessario. Nessa ordem, por favor");
					Magia magia = new Magia(in.nextLine(), in.nextInt(), in.nextInt(), in.nextInt(), false);
					b2.inserir(magia);
					System.out.println("Deseja continuar ?");
					magias = in.next();
				}
				System.out.println("Digite sua descrição");
				in.next();
				String description2 = in.nextLine();
				Livro livro2 = new Livro(titulo2, b2, description2);
				try {
					a.atualizar(tituloatt, livro2);
				} catch (LNEException e) {
					System.out.println(e.getMessage());
				}
				try {
					System.out.println(a.procurar("O fracasso do pudim").getDescription());
				} catch (LNEException e) {
					System.out.println(e.getMessage());
				}
				} 
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

