package br.com.missaci.firstchar;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstCharFinderTest {
	
	@Test
	public void firstScenario(){
		Stream stream = getStream(new char[]{'a','A','b','B','A','B','a','c'});
		
		char found = FirstCharFinder.firstChar(stream);
		
		assertEquals('b', found);
		
	}
	
	@Test
	public void secondScenario(){
		Stream stream = getStream(new char[]{'a','A','A','B','A','B','a','c','D','d'});
		
		char found = FirstCharFinder.firstChar(stream);
		
		assertEquals('c', found);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void failureScenario(){
		Stream stream = getStream(new char[]{'a','A','A','B','A','B','a','c','c'});
		
		FirstCharFinder.firstChar(stream);
		
	}
	
	private Stream getStream(final char[] chars){
		return new Stream() {

			private int pointer = 0;
			
			@Override
			public boolean hasNext() {
				return pointer < chars.length;
			}
			
			@Override
			public char getNext() {
				char actualChar = chars[pointer];
				pointer++;
				return actualChar;
			}
		};
	}

}
