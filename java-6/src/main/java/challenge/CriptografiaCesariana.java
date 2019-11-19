package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
    	return cryptDecrypt(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {
    	return cryptDecrypt(texto, -3);
    }
    
    private String cryptDecrypt(String texto, int shift) {
    	Integer charCode, jumped;
		String newText = "";
		char charText;
		
		if(texto.isEmpty())
			throw new IllegalArgumentException();
		
		for (int i = 0; i < texto.length(); i++) {
			charText = texto.charAt(i);
			charText = Character.toLowerCase(charText);
			charCode = (int)charText;
			
			if(charCode > 96 && charCode < 123) {
				jumped = ((charCode - 97) + shift) % 26;
				charText = (char)(jumped + 97);
			}
			
			newText += charText;
		}
		
		return newText;
	}
}
