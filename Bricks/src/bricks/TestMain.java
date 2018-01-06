package bricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestMain {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer> obst = new ArrayList<>();
		obst.add(1);
		obst.add(1);
		obst.add(2);
		obst.add(2);
		

		Tree tree = new Tree();
		tree.root.board.init(3, obst);
		tree.root.board.printBoard();
		tree.root.whoseMove = 1;
		System.out.println("---------");
		tree.generateMove();
		tree.root.board.printBoard();
		
		
		/*tree.root.generateChildren();
		System.out.println(tree.root.children.size());
		System.out.println("---------");
		tree.root.children.get(0).board.printBoard();
		tree.generateLevel();
		System.out.println("---------");
		tree.root.children.get(0).children.get(2).board.printBoard();*/
		
		
		
		/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		if((input = reader.readLine()).equals("start")) {
			
			System.out.println("Ja zaczynam");
			while(true) {
				System.out.println("Generowany ruch");
				input = reader.readLine();
				System.out.println("Ruch przeciwnika: " + input);
			}
		} 
		else {
			System.out.println("Przeciwnik zaczyna");
			System.out.println("Ruch przeciwnika: " + input);
			while(true) {
				System.out.println("Generowany ruch");
				input = reader.readLine();
				System.out.println("Ruch przeciwnika: " + input);
			}
			
		}*/
		
			
		
	}
	
}
