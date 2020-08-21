import java.util.ArrayList;
import java.util.Hashtable;

public class Node {
	private boolean status;
	private int row ;
	private int number;
	ArrayList<Node> connections = new ArrayList<Node>();
	
	Node(int r, int n, boolean s){
		row = r;
		number = n;	
		status = s;
	}


	public void changeStatus() {
		if (status)
			status = false;
		else {
			status = true;
		}
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public int getRow() {
		return row;
	}
	public int getNumber() {
		return number;
	}

	public void createCon(){
	}
	
	
	public ArrayList<String> checkMove(Hashtable<String, Node> nodes) {
		ArrayList<String> moves = new ArrayList<String>();
		if (status) {
			/*
			 * Checking in the row
			 */
			if (number +2 <= row)
				if (!nodes.get(""+row+(number+2)).getStatus())
					if (nodes.get(""+row+(number+1)).getStatus())
						moves.add("("+row+number+","+row+(number+1)+","+row+(number+2)+")");
			if (number - 2 >0)
				if (!nodes.get(""+row+(number-2)).getStatus())
					if (nodes.get(""+row+(number-1)).getStatus())
						moves.add("("+row+number+","+row+(number-1)+","+row+(number-2)+")");
			/*
			 * Checking diagonal with same node number
			 */
			
			if (row +2 <= 5)
				if (!nodes.get(""+(row+2)+number).getStatus())
					if (nodes.get(""+(row+1)+number).getStatus())
						moves.add("("+row+number+","+(row+1)+number+","+(row+2)+number+")");
			if (row - 2 >0 && row - 2 >= number)
				if (!nodes.get(""+(row-2)+number).getStatus())
					if (nodes.get(""+(row-1)+number).getStatus())
						moves.add("("+row+number+","+(row-1)+number+","+(row-2)+number+")");
			
			
			/*
			 * Checking diagonal with different node number
			 */
			
			if (row +2 <= 5 )
				if (!nodes.get(""+(row+2)+(number+2)).getStatus())
					if (nodes.get(""+(row+1)+(number+1)).getStatus())
						moves.add("("+row+number+","+(row+1)+(number+1)+","+(row+2)+(number+2)+")");
			if (row - 2 >0 && number -2 > 0)
				if (!nodes.get(""+(row-2)+(number-2)).getStatus())
					if (nodes.get(""+(row-1)+(number-1)).getStatus())
						moves.add("("+row+number+","+(row-1)+(number-1)+","+(row-2)+(number-2)+")");
			
			
		}
	return moves;
	}
	
	
}













