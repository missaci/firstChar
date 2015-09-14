package br.com.missaci.firstchar;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Implementa��o para achar o primeiro char que n�o se repete em um Stream.
 * Foi usado um HashMap para mapeamento de contagem de repeti��o, por ser uma estrutura
 * de tempo de pesquisa constante.
 * Uma instancia de StringBuilder foi usada para manter a ordem dos caracters ao mesmo tempo
 * em que mant�m a manipula��o de uma estrutura de caracters r�pida, diferentemente de usar diretamente
 * uma String.
 * 
 * @author Mateus
 *
 */
public class FirstCharFinder {

	public static char firstChar(Stream stream){
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder builder = new StringBuilder();
		
		readStreamContent(stream, map, builder);
		
		for (int i = 0; i < builder.length(); i++) {
			char character = builder.charAt(i);
			
			if(map.get(character) == 1){
				return character;
			}
		}
		
		throw new RuntimeException("Nenhum caracter que n�o se repita foi encontrado");
	}

	private static void readStreamContent(Stream stream, Map<Character, Integer> map, StringBuilder builder) {
		while(stream.hasNext()){
			char character = stream.getNext();
			builder.append(character);
			
			if(map.containsKey(character)){
				map.put(character, map.get(character)+1);
			
			}else{
				map.put(character, 1);
			}
		}
	}
	
}
