package bricks;

public class Tree {

	Node root = new Node();
	
	public void generateLevel() {
		
		for(int i=0; i<root.children.size(); i++)
			root.children.get(i).generateChildren();
	}
	
	public void setValues() {
		//TODO
		//metoda do przypisywania wartoœci liœciom drzewa
	}
	
	public void generateMove() {
		//TODO
		//metoda do wybierania kolejnego ruchu
	}
	
	public void followMove(int x1, int y1, int x2, int y2) {
		//TODO
		//metoda do œledzenia ruchu przeciwnika
		//do poprawienia
		for(int i=0; i<root.children.size(); i++) {
			if(root.children.get(i).moveX1 == x1 &&
					root.children.get(i).moveY1 == y1 &&
					root.children.get(i).moveX2 == x2 &&
					root.children.get(i).moveY2 == y2) {
				root = root.children.get(i);
				root.generateChildren();
				return;
			}
		}
		
	}
	
}
