package ProjetoPack;

import ElementalException.CNEException;

public class HappyArrey implements InterfaceElemental {
 
    Elemental[] Elementais;
    int indice;
 
    public HappyArrey(int indice) {
        Elementais = new Elemental[indice];
        indice = 0;
    }
 
    public void inserir(Elemental elemental) {
        Elementais[indice] = elemental;
        indice++;
    }
 
    public Elemental procurar(String nomeElemental) {
        Elemental nome = null;
        boolean achou = false;
        for (int contador = 0; !achou && (contador < indice); contador++) {
            nome = Elementais[contador];
            if (nome.getNomeElemental().equals(nomeElemental)) {
                achou = true;
            } else {
                nome = null;
            }
        }
        return nome;
    }
 
    public boolean existe(String nomeElemental) { // informa se um elemental existe.
        Elemental a = this.procurar(nomeElemental);
        if (a != null) {
            return true;
        } else {
            return false;
        }
    }
 
    public void remover(String nomeElemental) {
 
        for (int i = 0; i < indice; i++) {
            if (Elementais[i].getNomeElemental().equals(nomeElemental)) {
                indice--;
                Elementais[i] = Elementais[indice];
            }
        }
    }
 
    public void atualizar(Elemental elemental) { // A partir de outro elemental com nome identico, muda seus demais
                                                    // dados.
        String a = elemental.getNomeElemental();
        remover(a);
        inserir(elemental);
    }
 
    public String grau(String nomeElemental) throws CNEException{ //Metodo para dizer o Grau de um elemental.
        Elemental a = this.procurar(nomeElemental);
        if (a != null) {
            if (a.getGrauElemental() == 1) {
                return "Low Elemental";
            } else if (a.getGrauElemental() == 2) {
                return "Normal Elemental";
            } else if (a.getGrauElemental() == 3) {
                return "High Elemental";
            } else if (a.getGrauElemental() == 0) {
                return "Useless Elemental";
            } else {
                return "Godless Elemental";
            }
        } else {
        throw new CNEException();
        }
    }
}
