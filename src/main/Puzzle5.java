package main;

import java.util.LinkedList;
import java.util.List;

public class Puzzle5 extends Puzzle {
	
	private static final int LOWER_UPPER_DIFF = 32;
	
	Puzzle5 (String input) {
		super(input);
	}

	@Override
	public String solvePuzzle() {
		List<Character> solution = null;
		
		if (this.input == null) {
			return NO_SOLVED;
		}
		
		char[] inputArray = this.input.toCharArray();
		LinkedList<Character> list = arrayToList(inputArray);
		
		solution = reduceInput(list, 0);
		
	    System.out.println("Cantidad de elementos restantes: " + solution.size());
		return solution.toString();
	}

	private boolean react(char first, char second) {
		
		if (first == '\0' || second == '\0') {
			return false;
		}
		
		int diff = Math.abs(((int) first) - ((int) second));
		
		if (diff != LOWER_UPPER_DIFF) {
			return false;
		}
		
		return true;
	}
	
	private LinkedList<Character> reduceInput(LinkedList<Character> input, int idx) {
		boolean removeAtIndex = false;
		int index;
		char value;
		char nextValue;
		int nextIndex;
		
		for (index = idx; index < input.size(); index++) {
			value = input.get(index);
			nextValue = index < input.size() - 1 ? input.get(index + 1) : '\0';
			
			if (react(value, nextValue)) {
				removeAtIndex = true;
				break;
			}
		}
		
		if (removeAtIndex) {
			input.remove(index);
			input.remove(index);
			
			nextIndex = index == 0 ? index + 1 : index - 1; 
			value = input.get(index);
			nextValue = index < input.size() - 1 ? input.get(nextIndex) : '\0';
			
			while(react(value, nextValue)) {
				input.remove(index);
				input.remove(index);
				
				value = input.get(index);
				nextValue = index < input.size() - 1 ? input.get(nextIndex) : '\0';
			}
			
			return reduceInput((LinkedList<Character>) input.clone(), index);
		}
		
		return input;
	}
	
	private LinkedList<Character> arrayToList(char[] inputArray) {
		LinkedList<Character> list = new LinkedList<>();
		
		for (int i = 0; i < inputArray.length; i++) {
			list.push(inputArray[i]);
		}
		
		return list;
	}

}
