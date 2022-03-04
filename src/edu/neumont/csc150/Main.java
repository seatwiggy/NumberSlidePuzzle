package edu.neumont.csc150;

import edu.neumont.csc150.controller.GameMaster;
import edu.neumont.csc150.models.Sudoku;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		new GameMaster().run();
	}
}