package bricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBricks {

	public static void main(String[] args) throws IOException {
		
		Communicator communicator = new Communicator();
		Tree tree = new Tree();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		input = reader.readLine();
		communicator.readInit(input);
		tree.root.board.init(communicator.size, communicator.obstacles);
		System.out.println("OK");
		
		input = reader.readLine();
		if(input.toUpperCase().equals("START")) {
			tree.root.whoseMove = 1;
			while(true) {
				tree.generateMove();
				communicator.writeMove(tree.root);
				input = reader.readLine();
				if(input.toUpperCase().equals("STOP"))
					return;
				communicator.readOppMove(input);
				tree.updateWithOppMove(communicator.oppMoveX1, communicator.oppMoveY1,
						communicator.oppMoveX2, communicator.oppMoveY2);
			}
		}
		else {
			tree.root.whoseMove = 2;
			communicator.readOppMove(input);
			tree.updateWithOppMove(communicator.oppMoveX1, communicator.oppMoveY1,
					communicator.oppMoveX2, communicator.oppMoveY2);
			while(true) {
				tree.generateMove();
				communicator.writeMove(tree.root);
				input = reader.readLine();
				if(input.toUpperCase().equals("STOP"))
					return;
				communicator.readOppMove(input);
				tree.updateWithOppMove(communicator.oppMoveX1, communicator.oppMoveY1,
						communicator.oppMoveX2, communicator.oppMoveY2);
			}
		}
	}
}
