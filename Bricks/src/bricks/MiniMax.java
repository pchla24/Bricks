package bricks;

public class MiniMax {
	
	public static Node getMax(Node node) {
		
		Node max = node.children.get(0);
		for(int i=1; i<node.children.size(); i++) {
			if(max.moveValue < node.children.get(i).moveValue)
				max = node.children.get(i);
		}
		return max;
	}
	
	public static int getMin(Node node) {
		
		int min = node.children.get(0).moveValue;
		for(int i=1; i<node.children.size(); i++) {
			if(min > node.children.get(i).moveValue)
				min = node.children.get(i).moveValue;
		}
		return min;
	}
	
	public Node doMinimax(Tree tree) {
		
		for(int i=0; i<tree.root.children.size(); i++)
			tree.root.children.get(i).moveValue = getMin(tree.root.children.get(i));
		return getMax(tree.root);
	}

}
