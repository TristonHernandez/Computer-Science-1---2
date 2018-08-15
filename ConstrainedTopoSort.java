// Triston Hernandez
// tr548460
// ConstrainedTopoSort - a program that uses the algorithm for a topoligical sort to 
// check whether a certain vertex x can come before another vertex y  

import java.io.*;
import java.util.*;


public class ConstrainedTopoSort{
 
	public boolean [][] matrix;
	
	// Here we need a constructor to intilize our adjaceny matrix, and scan our graph into
	// the recent initilized matrix.
	public ConstrainedTopoSort(String filename) throws IOException
	{
		
		Scanner in = new Scanner(new File(filename));
		int n = in.nextInt();
		boolean print = false;
		this.matrix = new boolean[n][n];
			
		for(int i = 0; i < n; i++)
		{
			int numEdge = in.nextInt();
			for(int j = 0; j < numEdge; j++)
			{
			 int edge = in.nextInt();
			 if(edge < 1)
				 this.matrix[i][j] = false;
			 else
				 this.matrix[i][edge - 1] = true;
			}
			
			if(print == true)
			{
				
				for(int m = 0; m < n; m++)
				{
					System.out.print(((this.matrix[i][m]) ? 1 : 0) + " ");
				
				}
				
				System.out.println();
			
			}
		}
	}
	
	// 
	public boolean hasConstrainedTopoSort(int x, int y) 
    {
			
			int cnt = 0;
			Queue<Integer> q = new ArrayDeque<>();
			int [] incoming = new int[matrix.length];
			int [] outgoing = new int[matrix.length];
			
			for(int i = 0; i < matrix.length; i++)
			{
				for(int j = 0; j < matrix.length; j++)
				{
					incoming[j] += (matrix[i][j] ? 1 : 0);
					outgoing[i] += (matrix[i][j] ? 1 : 0);
				}		
			}
			
			// Make sure our sort is a valid topo sort & that x comes before y.
			for(int i = 0; i < matrix.length; i++)
			{
				if(incoming[i] == 0)
					q.add(i);
			}
			
			while(!q.isEmpty())
			{
				int node = q.remove();
				cnt++;
				
				for(int i = 0; i < matrix.length; i++)
				{
					if(matrix[node][i] && --incoming[i] == 0)
					{
						q.add(i);
					}
				}
			}
			//System.out.println("incoming at y: " + incoming[y-1]);
			//System.out.println("outgoing at y: " + outgoing[y-1]);
			//System.out.println();
			//System.out.println("incoming at x: " + incoming[x-1]);
			//System.out.println("outgoing at x: " + outgoing[x-1]);
			
			if(cnt != matrix.length)
			{
				return false;
			}
			//System.out.println("incoming at y: " + incoming[y-1] + ", outgoing at y: " + outgoing[y-1]);
			//System.out.println(matrix.length);
			//System.out.println("end of iter");
			
			try{
			if((incoming[y-1] == 0) && outgoing[y-1] == 0) // < --- needs to be fixed
			{
				return true;
			}
			}catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Error");
			}
			// At this point we have gone through and seen that this graph 1) has a valid toposort
			// and 2) there is no cycle
			// next we need to check and see if there is a path from y to x
			// ill do that using a DFS
			
			boolean noPath = DFS(y - 1, x - 1);
			if(!noPath)
				return false;
			// we now know that there is no cycle and that there is no path from y to x, last thing to 
			// make sure of is that if our x is a disconnected node then you know that there is a valid
			// toposort
			return true;
	}
	
	public boolean DFS(int start, int end) {
		
		int n = matrix.length;
		boolean[] visited = new boolean[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int u = stack.pop();
			
			if(!visited[u]) {
				visited[u] = true;
				for(int v = 0; v < n; v++)
					if(matrix[u][v])
						stack.push(v);
			}
		}
		
		return !visited[end];
	}
	/*
	public boolean DFS(int x, int y) 
	{
		boolean [] visited  = new boolean[matrix.length];
		return DFS(x, y, visited);
	}
	
	private boolean DFS(int x, int y, boolean [] visited) 
	{

		visited[x] = true;
		System.out.println("x = " + x + "\n");
		System.out.println("y = " + y + "\n");
		
		if(x == y)
			return false;

		for(int i = 0; i < matrix.length; i++)
		{
			if(matrix[x-1][i] && !visited[i])
				DFS(i, y, visited);
			
		}
		visited[x] = false;
		
		return true;
	}
	*/
	public static double difficultyRating()
	{
		return 3.0;
	}
	public static double hoursSpent()
	{
		return 10.0;
	}
/*	
	public static void main(String [] args) throws Exception
	{
	
		ConstrainedTopoSort s = new ConstrainedTopoSort("g1.txt");
			
			for(int i = 0; i < 4; i++)
			{
				for(int m = 0; m < 4; m++)
				{
					System.out.print(((s.matrix[i][m]) ? 1 : 0) + " ");
				
				}
				System.out.println();
			}
			
		if (s.hasConstrainedTopoSort(1, 2) != true) System.out.println(false);
		if (s.hasConstrainedTopoSort(1, 3) != true) System.out.println(false);
		if (s.hasConstrainedTopoSort(1, 4) != true) System.out.println(false);
		
		if (s.hasConstrainedTopoSort(2, 1) != true) System.out.println(false);
		if (s.hasConstrainedTopoSort(2, 3) != true) System.out.println(false);
		if (s.hasConstrainedTopoSort(2, 4) != true) System.out.println(false);
		
		if (s.hasConstrainedTopoSort(3, 1) != false) System.out.println(false);
		if (s.hasConstrainedTopoSort(3, 2) != false) System.out.println(false);
		if (s.hasConstrainedTopoSort(3, 4) != true) System.out.println(false);
		
		if (s.hasConstrainedTopoSort(4, 1) != false) System.out.println(false);
		if (s.hasConstrainedTopoSort(4, 2) != false) System.out.println(false);
		if (s.hasConstrainedTopoSort(4, 3) != false) System.out.println(false);
		
		System.out.println("Hooray!");
	}
*/
}