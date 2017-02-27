
import edu.princeton.cs.algs4.*;

public class Diameter {
	private boolean[] marked;
	private int[] distTo;
	private int N;
	private int diameter;
	
	public Diameter(Graph graph) {
		N = graph.V();
		marked = new boolean[N];
		distTo = new int[N];
		
		dfs(graph,0);
		
		int x = getMostDistant();
		for (int i=0; i<N; i++) {
			marked[i] = false;
			distTo[i] = 0;			
		}
		dfs(graph, x);
		diameter = distTo[getMostDistant()];
	}
	
	public int diameter() {
		return diameter;
	}
	 
	private int getMostDistant() {
		int max = distTo[0];
		int maxI = 0;		
		for (int i=0; i<N; i++)
			if (distTo[i]>max) {
				max = distTo[i];
				maxI = i;				
			}
		return maxI;
	}
	
	private void dfs(Graph graph, int v) {
		marked[v] = true;
		for (int w : graph.adj(v)) {
			if (!marked[w]) {
				distTo[w] = distTo[v] + 1;
				dfs(graph, w);				
			}			
		}		
	}
}