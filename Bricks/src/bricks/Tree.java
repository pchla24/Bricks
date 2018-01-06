package bricks;

public class Tree {

	Node root = new Node();
	MiniMax minimax = new MiniMax();
	
	public void generateLevel() {
		
		for(int i=0; i<root.children.size(); i++)
			root.children.get(i).generateChildren();
	}
	
	public void setValues() {
		
		for(int i=0; i<root.children.size(); i++) 
			for(int j=0; j<root.children.get(i).children.size(); j++) 
				root.children.get(i).children.get(j).setMoveValue();
			
	}
	
	public void generateMove() {
		
		root.generateChildren();
		
		if(root.children.size() > 20) {
			root = root.children.get(0);
			return;
		}
		
		this.generateLevel();
		
		for(int i=0; i<root.children.size(); i++)
			if(root.children.get(i).children.isEmpty()) {
				root = root.children.get(i);
				return;
			}
		
		this.setValues();
		root = minimax.doMinimax(this);
		root.children.clear();
		
	} 
			
		
	public void followMove(int x1, int y1, int x2, int y2) {
		
		root.generateChildren();
		
		for(int i=0; i<root.children.size(); i++) {
			if(root.children.get(i).moveX1 == x1 &&
					root.children.get(i).moveY1 == y1 &&
					root.children.get(i).moveX2 == x2 &&
					root.children.get(i).moveY2 == y2) {
				root = root.children.get(i);
				return;
			}
		}
		
	}
	
	public void updateWithOppMove(int x1, int y1, int x2, int y2) {
		
		root.board.intBoard[x1][y1] = 2;
		root.board.intBoard[x2][y2] = 2;
		root.whoseMove = 1;
	}
	
}

