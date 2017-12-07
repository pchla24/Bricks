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
	
	public void followMove() {
		//TODO
		//metoda do œledzenia ruchu przeciwnika
	}
	
}
