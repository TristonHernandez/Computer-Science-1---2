import java.io.*;
import java.util.*;

public class TopoPath{

	public static boolean hasTopoPath(String filename) throws IOException
	{
		Scanner in = new Scanner(new File(filename));
		int n = in.nextInt();
		boolean print = false;
		boolean [][] matrix = new boolean[n][n];
			
		for(int i = 0; i < n; i++)
		{
			int numEdge = in.nextInt();
			for(int j = 0; j < numEdge; j++)
			{
			 int edge = in.nextInt();
			 if(edge < 1)
				 matrix[i][j] = false;
			 else
				 matrix[i][edge - 1] = true;
			}
			
			if(print == true)
			{
				
				for(int m = 0; m < n; m++)
				{
					System.out.print(((matrix[i][m]) ? 1 : 0) + " ");
				
				}
				
				System.out.println();
			
			}
		}
		
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
				//System.out.println("incoming edges: " + incoming[i]);
				//System.out.println("outgoing edges: " + outgoing[i]);
			}
		
		int incomingCount = 0;
		
		for(int i = 0; i < incoming.length; i++)
		{
			if(incoming[i] == 0)
				incomingCount++;
		}
		//System.out.println("# of nodes w/ no incoming edges: " + incomingCount);
		if(incomingCount > 1)
			return false;
	
		for(int i = 0; i < matrix.length; i++)
		{
			if(incoming[i] == 0)
				q.add(i);
		}
			
			while(!q.isEmpty())
			{
				int node = q.remove();
				//System.out.println(node);
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
		
		return true;
	}
	
	/*		
	public boolean DFS(int start, int end)
	{
		
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
		System.out.println((TopoPath.hasTopoPath("g1.txt")));
	}
	*/
}