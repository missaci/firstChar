package br.com.missaci.firstchar;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Implementação para achar o primeiro char que não se repete em um Stream.
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
		
		throw new RuntimeException("Nenhum caracter que não se repita foi encontrado");
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
