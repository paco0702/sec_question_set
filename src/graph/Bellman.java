package graph;

public class Bellman {
	Bellman(){
		
	}
	
	public static void main(String [] args) {
		// A0, B1, C2, D3 , E4
		
		int [][] graph = {
				{0,-1,4,0,0},
				{0,0,3,2,2},
				{0,0,0,0,0},
				{0,1,5,0,0},
				{0,0,0,-3,0}
		};
		int [] VE = new int [graph.length];
		VE[0] = 0;
		// assign infinte 
		for(int i=1; i<VE.length; i++) {
			VE[i] = -10;
		}
		
		// if VE [i]  = -10 which mean it is infinite
		Bellman b = new Bellman();
		int [] result = b.relax(graph, VE, 0);
		
	}
	
	public int [] relax(int [][] graph, int [] VE, int v) {
		for(int i=0; i<graph[v].length; i++) {
			// if there is edge connected then enter 
			if(graph[v][i]!=0) {
				// the start vertex 
				int sumWeight = VE[v];
				
				if(VE[i]==-10) {
					// if it is infinite 
					VE[i] = VE[v] + graph[v][i];
					//update the weigth in the graph
					
					// after the update 
					// do the same to that vertex 
					
					// check if there is cycle
					if(VE[i] + graph[i][v]  < VE[v]&& graph[i][v]!=0) {
						System.out.println(i+ ":¡@There is cycle");
					}
					relax(graph, VE, i);
				}else if(VE[i] > (VE[v]+graph[v][i])) {
					VE[i] = VE[v] + graph[v][i];
					relax(graph, VE, i);
					if(VE[i] > VE[v] + graph[i][v]) {
						System.out.println("There is cycle");
					}
				}
			}
		}
		
		return VE;
	}
}
