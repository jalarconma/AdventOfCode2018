package main;

public abstract class Puzzle {

	protected static final String NO_SOLVED = "NO_SOLVED";
	
	protected String input;
	
	Puzzle(String input) {
		this.input = input;
	}
	
	public abstract String solvePuzzle();
}
