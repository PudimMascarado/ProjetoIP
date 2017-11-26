package ProjetoPack;

import ElementalException.CNEException;

public class HappyList implements InterfaceElemental {
 
    Elemental elemental;
    HappyList proximo;
 
    public HappyList() {
        this.elemental = null;
        this.proximo = null;
    }
 
    public void inserir(Elemental elemental) {
        if (this.elemental == null) {
            this.elemental = elemental;
            this.proximo = new HappyList();
        } else {
            this.proximo.inserir(elemental);
        }
    }
 
    public Elemental procurar(String nomeElemental) {
        Elemental nome = null;
        if (this.elemental != null) {
            if (this.elemental.nomeElemental.equals(nomeElemental)) {
                nome = this.elemental;
                return nome;
            } else {
                return this.proximo.procurar(nomeElemental);
            }
        } else {
            return nome;
        }
 
    }
 
    public boolean existe(String nomeElemental) { // informa se um elemental existe.
    	boolean achou = false;
        if (this.elemental != null) {
        	if(this.elemental.getNomeElemental().equals(nomeElemental)) {
            achou = true;
        	} else {
        		this.proximo.existe(nomeElemental);
        } 
        }
        return achou;
    }
 
    public void remover(String nomeElemental) throws CNEException {
        if (this.elemental != null) {
            if (this.elemental.nomeElemental.equals(nomeElemental)) {
                if (this.proximo.elemental == null) {
                    this.elemental = null;
                    this.proximo = null;
                } else {
                    this.elemental = this.proximo.elemental;
                    this.proximo = this.proximo.proximo;
                }
            } else {
                this.proximo.remover(nomeElemental);
            }
        } else {
            throw new CNEException();
        }
    }
 
    public void atualizar(Elemental elemental) throws CNEException{ // A partir de outro elemental com nome identico, muda seus demais
                                                    // dados.
        String a = elemental.getNomeElemental();
        remover(a);
        inserir(elemental);
    }
 
    public String grau(String nomeElemental) throws CNEException { // Metodo para dizer o Grau de um elemental.
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
                return "Divine Elemental";
            }
        } else {
            throw new CNEException();
        }
    }
 
    public String idade(String nomeElemental) throws CNEException {
        Elemental a = this.procurar(nomeElemental);
        String idade = "";
        if (a != null) {
            return idade += a.getIdadeElemental();
        } else {
            throw new CNEException();
        }
    }
}