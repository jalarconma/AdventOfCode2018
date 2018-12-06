package main;

import java.util.LinkedList;
import java.util.List;

public class Puzzle5 extends Puzzle {
	
	private static final int LOWER_UPPER_DIFF = 32;
	
	private LinkedList<Character> reducedList = new LinkedList<>();
	
	Puzzle5 (String input) {
		super(input);
	}

	@Override
	public String solvePuzzle() {
		LinkedList<Character> solution = null;
		
		if (this.input == null) {
			return NO_SOLVED;
		}
		
		char[] inputArray = this.input.toCharArray();
		LinkedList<Character> list = arrayToList(inputArray);
		
		solution = reduceInput2(list);
		
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
	
	private LinkedList<Character> reduceInput2(LinkedList<Character> input) {
		char value;
		char nextValue;
		
		if (input.isEmpty()) {
			return input;
		}
		
		value = input.pop();
		nextValue = !input.isEmpty() ? input.pop() : '\0';
		
		if (!react(value, nextValue)) {
			applyReductionOnList(value, nextValue);
			return reduceInput2(input);
		}
		
		return reduceInput2(input);
	}
	
	private void applyReductionOnList(char first, char last) {
		char firstReducedValue;
		
		if (reducedList.isEmpty()) {
			
			if (first != '\0') {
				reducedList.push(first);
			}

			if (last != '\0') {
				reducedList.push(last);
			}
			
			return;
		}
		
		firstReducedValue = reducedList.pop();
		
		if (!react(first, firstReducedValue)) {
			
			if (firstReducedValue != '\0') {
				reducedList.push(firstReducedValue);
			}

			if (first != '\0') {
				reducedList.push(first);
			}
			
			if (last != '\0') {
				reducedList.push(last);
			}
			
			return;
		}
		
		if (reducedList.isEmpty()) {
			
			if (last != '\0') {
				reducedList.push(last);
			}
			
			return;
		}
		
		firstReducedValue = reducedList.pop();
		
		if (!react(last, firstReducedValue)) {
			
			if (firstReducedValue != '\0') {
				reducedList.push(firstReducedValue);
			}

			if (last != '\0') {
				reducedList.push(last);
			}
			
			return;
		}
		
	}

	private LinkedList<Character> arrayToList(char[] inputArray) {
		LinkedList<Character> list = new LinkedList<>();
		
		for (int i = 0; i < inputArray.length; i++) {
			list.push(inputArray[i]);
		}
		
		return list;
	}

}
