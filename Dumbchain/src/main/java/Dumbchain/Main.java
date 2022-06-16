package Dumbchain;

import java.util.ArrayList;

    public class Main {
	
	public static ArrayList<Bloco> cadeiaDeBlocos = new ArrayList<>();
	public static int dificuldade = 2; //Ajuste o nível de dificuldade.

	public static void main(String[] args) {	
		
	System.out.println("Minerando o primeiro bloco.. ");
            adicionarBloco(new Bloco("Bloco 1", "0"));
		
	System.out.println("Minerando o bloco 2.. ");
            adicionarBloco(new Bloco("Bloco 2", cadeiaDeBlocos.get(cadeiaDeBlocos.size()-1).hash));
		
	System.out.println("Minerando o bloco 3.. ");
            adicionarBloco(new Bloco("Bloco 3", cadeiaDeBlocos.get(cadeiaDeBlocos.size()-1).hash));
            
        System.out.println("Minerando o bloco 4.. ");
            adicionarBloco(new Bloco("Bloco 4", cadeiaDeBlocos.get(cadeiaDeBlocos.size()-1).hash));    
		
	System.out.println("\nValidação da cadeia de blocos: "+validarCorrente());
                    
	String cadeiaDeBlocosJson = Util.obterJson(cadeiaDeBlocos);
        
	System.out.println("\nNovo bloco é: "+cadeiaDeBlocosJson);
	}
	
	public static Boolean validarCorrente() {//Função de validação da cadeia de blocos.
        
            Bloco blocoAtual; 
            Bloco blocoAnterior;
            
            String hashAlvo = new String(new char[dificuldade]).replace('\0', '0');
		
            for(int i=1; i < cadeiaDeBlocos.size(); i++) {
                blocoAtual = cadeiaDeBlocos.get(i);
                blocoAnterior = cadeiaDeBlocos.get(i-1); 
			
                if(!blocoAtual.hash.equals(blocoAtual.calcularHash())){//Compara o hash do bloco atual com o calculado.
                    System.out.println("O código hash não é igual.");			
                        return false;
                }
			
                if(!blocoAnterior.hash.equals(blocoAtual.hashanterior)) {//Compara o hash do bloco anterior, com o hash armazenado no bloco atual.
                    System.out.println("O hash anterior não é igual.");
                        return false;
                }
			
                if(!blocoAtual.hash.substring(0, dificuldade).equals(hashAlvo)) {//Confere se o hash foi validado.
                    System.out.println("Este bloco hash ainda não foi gerado.");
                        return false;
                }		
            }
            return true;
	}
	
        public static void adicionarBloco(Bloco novoBloco) {//Passando toda a validação, é adicionado um novo bloco na cadeia.
            novoBloco.minerarBloco(dificuldade);
            cadeiaDeBlocos.add(novoBloco);
        }
    }
