package main;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) throws IOException {
	    String fileName = "puzzle5Input.txt";
	    String input = FileUtil.filterFileData(fileName);
	    
	    Puzzle5 puzzle = new Puzzle5(input);
	    String solution = puzzle.solvePuzzle();
	    
	    System.out.println(solution);
	}
}
