// -----------------\\
// Triston Hernandez
// tr548460
// 12-3-2017
// RunLikeHell.java - program that utilizes dynamic programming to solve a problem with
// polynomial runtime
//-------------------//

public class RunLikeHell
{
	// This is a wrapper function that passes in the string length of our array to another
	// function that will actually solve the problem
    public static int maxGain(int [] blocks)
    {
        int n = blocks.length;
		int [] maxGain = new int[n + 1];
        return maxGainDP(blocks, n, maxGain);
    }
	
	// This is the same function done with a recursive solution opposed to a Dynamic programming solution
    public static int maxGain(int [] blocks, int n)
    {
        if(n <= 0) return 0;
        if(n == 1) return blocks[n - 1];
		
		//---- For Testing ----
		/*
        //Choose first block you see
        int chooseB1 = blocks[n-1] + maxGain(blocks, n - 3);
        System.out.println("Choose B1: " + chooseB1);
        //Dont Choose first, take the second block you see
        
		int chooseB2 = blocks[n - 2] + maxGain(blocks, n - 4);
        System.out.println("Choose B1: " + chooseB1);
        */
		return Math.max(maxGain(blocks, n-1), blocks[n-1] + maxGain(blocks, n-2));
    }
	
	// Here is where the problem is being solved you will see a similarity between this and the recursive
	// function we simply replace the recursive calls with an array, and runs through a for loop
	// to make that trade of space for runtime
	public static int maxGainDP(int [] blocks, int n, int [] maxGain)
	{
		if(n <= 0) return 0;
   
		maxGain[0] = 0;
		maxGain[1] = blocks[0];
		
		//System.out.println("maxGain[1]: " + blocks[1]);
		for(int i = 2; i <= n; i++)
		{	
			//---- For testing ----
			/*
			System.out.println("i: " + i);
			System.out.println("maxGain[i - 1]: " + maxGain[i - 1]);
			System.out.println("maxGain[i - 2]: " + maxGain[i - 2]);
			System.out.println("blocks[i] + maxGain[i-2]: " + (blocks[i] + maxGain[i-2]));
			System.out.println("blocks[i]: " + blocks[i]);
			*/
			maxGain[i] = Math.max(maxGain[i - 1], (blocks[i - 1] + maxGain[i-2]));
			
		}
		// You want to return the last place in your answers array
		return maxGain[n];
	}
	public static double hoursSpent()
	{
		return 1.5;
	}
	public static double difficultyRating()
	{
		return 3.3;
	}
	/*
	public static void main (String[] args) throws java.lang.Exception
	{
	    int [] blocks = {1,2,3,4,5};
		int ans = RunLikeHell.maxGain(blocks);
		System.out.println(ans);
	}
	*/
}