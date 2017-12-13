package bricks;

import java.util.ArrayList;

public class Node {
	
	public int moveX1, moveY1, moveX2, moveY2;
	ArrayList<Node> children = new ArrayList<>();
	Board board = new Board();
	int moveValue;
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
					
					node.board.intBoard = new int[board.size][board.size];
					node.board.size = this.board.size;
					for(int i=0; i<board.size; i++)
						  for(int j=0; j<board.size; j++)
							  node.board.intBoard[i][j] = this.board.intBoard[i][j];
					
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
		
		for(int y=0; y<board.size-1; y++)						// vertical moves
			for(int x=0; x<board.size; x++)
				if(board.isLegalMove(x, y, x, y+1)){
					Node node = new Node();
					node.moveX1 = x;
					node.moveY1 = y;
					node.moveX2 = x;
					node.moveY2 = y+1;
					
					node.board.intBoard = new int[board.size][board.size];
					node.board.size = this.board.size;
					for(int i=0; i<board.size; i++)
						  for(int j=0; j<board.size; j++)
							 node.board.intBoard[i][j ]= board.intBoard[i][j];
					
					if(whoseMove == 1) {
						node.board.intBoard[x][y] = 1;
						node.board.intBoard[x][y+1] = 1;
						node.whoseMove = 2;
					} else {
						node.board.intBoard[x][y] = 2;
						node.board.intBoard[x][y+1] = 2;
						node.whoseMove = 1;
					}
					children.add(node);
				}
	}
	
	public void setMoveValue() {
		moveValue = board.calculateBoardValue();
	}


}
