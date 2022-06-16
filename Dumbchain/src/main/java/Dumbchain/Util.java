package Dumbchain;

import java.security.MessageDigest;
import com.google.gson.GsonBuilder;

public class Util {//Aplica a criptografia em uma String e retorna o valor em hexadecimal.
	
    public static String aplicarSha256(String input){	
	try {
            MessageDigest resumo = MessageDigest.getInstance("SHA-256");
            byte[] hash = resumo.digest(input.getBytes("UTF-8"));
            
            StringBuilder textoHexadecimal = new StringBuilder(); 
            
            for (int i = 0; i < hash.length; i++) {
		String hexadecimal = Integer.toHexString(0xff & hash[i]);  
                    if(hexadecimal.length() == 1) textoHexadecimal.append('0');
			textoHexadecimal.append(hexadecimal);
            }            
            return textoHexadecimal.toString();
	} catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
		
	public static String obterJson(Object o) {
            return new GsonBuilder().setPrettyPrinting().create().toJson(o);
	}
	
	public static String obterDificuldade(int dificuldade) {
            return new String(new char[dificuldade]).replace('\0', '0');
	}	
}
