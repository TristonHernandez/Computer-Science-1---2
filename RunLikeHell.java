import java.util.*;

public class RunLikeHell
{
	public static int maxGain(int [] blocks)
	{
		int n = blocks.length;
		return maxGain(blocks, n);
	}
	public static int maxGain(int [] blocks, int n)
	{
		blocks = new int[n];
		if(n > blocks.length) return n;
		System.out.println(Math.max(maxGain(blocks, n + 1), maxGain(blocks,0) + maxGain(blocks, n+2)));
		return Math.max(maxGain(blocks, n + 1), maxGain(blocks, 0) + maxGain(blocks, n + 2));
	}
	
	public static void main(String [] args)
	{
		int [] blocks = new int[] {15, 3, 6, 17, 2, 1, 20};
		int ans = 52;

		if (RunLikeHell.maxGain(blocks) != ans) System.out.println(maxGain(blocks));

		System.out.println("Hooray!");
	}

}