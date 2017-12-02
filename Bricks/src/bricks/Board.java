package bricks;

import java.util.ArrayList;

public class Board {
	
	int[][] intBoard;
	int size;
	
	public void init(int size, ArrayList<Integer> obstacles) {
		
		this.size = size;
		intBoard = new int[size][size];
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++)
				intBoard[j][i] = 0;
		}
		
		for(int a=0; a<obstacles.size(); a+=2)
			intBoard[obstacles.get(a)][obstacles.get(a+1)] = 3;
		
	}
	
	public boolean isLegalMove(int x1, int y1, int x2, int y2) {
		
		if(intBoard[x1][y1] == 0 && intBoard[x2][y2] == 0)
			return true;
		else
			return false;
	}
	
	public int calculateBoardValue() {
		//TODO
		return 1;
	}

}
