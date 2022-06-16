/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Dumbchain;

import static Dumbchain.Main.cadeiaDeBlocos;
import static Dumbchain.Main.dificuldade;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Otavio
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testValidarCorrente() {
        
            Bloco blocoAtual; 
            Bloco blocoAnterior;
            
            String hashAlvo = new String(new char[dificuldade]).replace('\0', '0');
		
            for(int i=1; i < cadeiaDeBlocos.size(); i++) {
                blocoAtual = cadeiaDeBlocos.get(i);
                blocoAnterior = cadeiaDeBlocos.get(i-1); 
			
                if(!blocoAtual.hash.equals(blocoAtual.calcularHash())){//Compara o hash do bloco atual com o calculado.
                    System.out.println("O código hash não é igual.");			
                    assertTrue(true);
                }
			
                if(!blocoAnterior.hash.equals(blocoAtual.hashanterior)) {//Compara o hash do bloco anterior, com o hash armazenado no bloco atual.
                    System.out.println("O hash anterior não é igual.");
                        
                }
			
                if(!blocoAtual.hash.substring(0, dificuldade).equals(hashAlvo)) {//Confere se o hash foi validado.
                    System.out.println("Este bloco hash ainda não foi gerado.");
                        
                }		
            }
         
        
    }

    @Test
    public void testAdicionarBloco() {
    }
    
}
