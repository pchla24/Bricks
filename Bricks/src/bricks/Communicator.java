package bricks;

import java.util.ArrayList;

public class Communicator {
	
	public int oppMoveX1, oppMoveY1, oppMoveX2, oppMoveY2;
	public int size;
	ArrayList<Integer> obstacles = new ArrayList<>();
	
	public void readInit(String str) {
		
		String []parts = str.split("_");
		String []subparts = new String[2];
		size = Integer.valueOf(parts[0]);
		for(int i=1; i<parts.length; i++) {
			subparts = parts[i].split("x");
			obstacles.add(Integer.valueOf(subparts[0]));
			obstacles.add(Integer.valueOf(subparts[1]));
		}
	}
	
	public void readOppMove(String str) {
		
		String[] parts = str.split("_");
		String[] subparts = new String[2];
		subparts = parts[0].split("x");
		oppMoveX1 = Integer.valueOf(subparts[0]);
		oppMoveY1 = Integer.valueOf(subparts[1]);
		subparts = parts[1].split("x");
		oppMoveX2 = Integer.valueOf(subparts[0]);
		oppMoveY2 = Integer.valueOf(subparts[1]);
	}
	
	public void writeMove(Node node) {
		
		System.out.println(node.moveX1 + 'x' + node.moveY1 + '_' + 
				node.moveX2 + 'x' + node.moveY2);
	}

}
