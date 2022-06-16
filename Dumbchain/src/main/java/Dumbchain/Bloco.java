package Dumbchain;

import java.util.Date;

public final class Bloco {
	
    public String hash;
    public String hashanterior;
    private final String ordem;
    private final long criado; //Momento em que foi criado.
    private int codigo; //Valor único de cada bloco.
		 
    public Bloco(String ordem, String hashanterior) { //Método construtor do bloco.
	
        this.ordem = ordem;
	this.hashanterior = hashanterior;
	this.criado = new Date().getTime();
	this.hash = calcularHash(); 
    }
	
    public String calcularHash() {//Função para calcular o hash.
	String hashCalculado = Util.aplicarSha256( 
				hashanterior +
				Long.toString(criado) +
				Integer.toString(codigo) + 
				ordem 
				);
	return hashCalculado;
    }

    public void minerarBloco(int dificuldade) {
	String alvo = Util.obterDificuldade(dificuldade); /*Inicia na dificuldade zero e vai adicionando dificuldade 
                                                          ou zeros ao hash na classe string util*/   
	while(!hash.substring(0, dificuldade).equals(alvo)) {
            codigo++;
            hash = calcularHash();
	}
	System.out.println("Bloco minerado: "+hash);
    }	
}

