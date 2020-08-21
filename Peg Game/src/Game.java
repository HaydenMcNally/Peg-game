import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		boolean notwin = true;
		Hashtable<String, Node> nodes = new Hashtable<String,Node>(); 
		nodes = createNodes();
		while (notwin) {
			for (String k :nodes.keySet() ) {
				ArrayList<String> moves = nodes.get(k).checkMove(nodes);
				if (!moves.isEmpty()) {
					System.out.println(k);
					System.out.println(moves);
				}
			}
			Scanner input = new Scanner(System.in);
			System.out.println("Enter next move in 'node','node jumped over','node landed on'");
			String nextMove = input.nextLine();
			doMove(nextMove,nodes);
			int num = 0;
			for (String k :nodes.keySet() ) {
				if (nodes.get(k).getStatus());
					num +=1;
				
			}
			if (num == 1) {
				notwin = false;
			}
			num = 0;
		}
	}
	
	
	public static Hashtable<String, Node> createNodes(){
		Hashtable<String, Node> nodes = new Hashtable<String,Node>(); 
		int row = 5;
		int num = 1;

		while (row >= 1 ) {
			while (num <= row) {
				Node n = new Node(row,num,true);
				nodes.put(""+row+num,n);
				num += 1;
			}
			row -= 1;
			num = 1;
		}
		System.out.println(nodes.keySet());
		Node n = nodes.get("11");
		n.changeStatus();
		return nodes;
	}
	
	
	public static void doMove(String s,Hashtable<String,Node> nodes) {
		String[] moves = s.split(",");
		nodes.get(moves[0]).changeStatus();
		nodes.get(moves[1]).changeStatus();
		nodes.get(moves[2]).changeStatus();
	}
}
