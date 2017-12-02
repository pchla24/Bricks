package bricks;

import java.util.ArrayList;

public class Node {
	
	public int moveX1, moveY1, moveX2, moveY2;
	ArrayList<Node> children = new ArrayList<>();
	Board board = new Board();
	int whoseMove;											// 1-me, 2-opponent
	
	public void generateChildren() {
		
		for(int y=0; y<board.size; y++)						// horizontal moves
			for(int x=0; x<board.size-1; x++)
				if(board.isLegalMove(x, y, x+1, y)){
					Node node = new Node();
					node.moveX1 = x;
					node.moveY1 = y;
					node.moveX2 = x+1;
					node.moveY2 = y;
					node.board.intBoard = board.intBoard;
					if(whoseMove == 1) {
						node.board.intBoard[x][y] = 1;
						node.board.intBoard[x+1][y] = 1;
						node.whoseMove = 2;
					} else {
						node.board.intBoard[x][y] = 2;
						node.board.intBoard[x+1][y] = 2;
						node.whoseMove = 1;
					}
					children.add(node);
				}
		
		
	}


}
