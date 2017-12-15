package bricks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBricks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Communicator communicator = new Communicator();
		Tree tree = new Tree();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		input = reader.readLine();
		communicator.readInit(input);
		tree.root.board.init(communicator.size, communicator.obstacles);
		System.out.println("ok");
		
		if((input = reader.readLine()).equals("start")) {
			tree.root.whoseMove = 1;
			while(true) {
				tree.generateMove();
				input = reader.readLine();
				communicator.readOppMove(input);
				tree.followMove(communicator.oppMoveX1, communicator.oppMoveY1,
						communicator.oppMoveX2, communicator.oppMoveY2);
			}
		}
		else {
			tree.root.whoseMove = 2;
			communicator.readOppMove(input);
			tree.followMove(communicator.oppMoveX1, communicator.oppMoveY1,
					communicator.oppMoveX2, communicator.oppMoveY2);
			while(true) {
				tree.generateMove();
				input = reader.readLine();
				communicator.readOppMove(input);
				tree.followMove(communicator.oppMoveX1, communicator.oppMoveY1,
						communicator.oppMoveX2, communicator.oppMoveY2);
			}
		}
	}
}
