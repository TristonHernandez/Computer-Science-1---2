import java.io.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.Math;
import java.lang.*;
import java.util.regex.*;

//===================\\
// Triston Hernandez
// tr548460
//===================\\

public class SneakyKnights
{
	// By the time this function is being called the String thats retrived from coordinateStrings
	// has been broken apart to a string of characters and returns the base converted number as an integer.
	public static int baseConversion(String s) {

		int result = 0, len = s.length();

		// Exactly like in SneakyQueens we go to each character in the string and find out its ascii value and
		// have the strings ascii value converted to base 26
		for(int i = 0; i < len; i++)
		{
			result += (s.charAt(i) - 'a' + 1)*Math.pow(26, len - 1 - i);
		}
		return result;
	}
	// This function is has a lot going on, as far as its implimentation, it first creating a HashSet
  // to contain all of the coordinates passed in, before we add anything to the Hashset first we
	// break apart the string passed into an (X, Y). Using the Point object we store every x and y
	// in a point and pass these points into the HashSet we created
	public static boolean allTheKnightsAreSafe(ArrayList<String> coordinateStrings, int boardsize)
	{

		int length = coordinateStrings.size();

		String coordinates = "";

		HashSet<Point> myhash = new HashSet<>();

		for(int i = 0; i < length; i++)
		{
			coordinates = coordinateStrings.get(i);

			String[] temp;

			// .split method implicitly stores strings in indexs 0 and 1 so we want to store the first part
			// of the string in temp set it equal to Y after we convert its base
			// and we convert the other part of the string(containing the rows) stored in temp[1]
			// to an int, store it in our X
			temp = coordinates.split("(?<=\\D)(?=\\d)");

			int temp2 = Integer.parseInt(temp[1]);

			int y = baseConversion(temp[0]);
			int x = temp2;

			// First need to create a Point storing or original point we got from coordinateStrings
			Point point = new Point(x, y);

			// clearly if the Hashset already contains the point its not valid, ergo return
			// false
			if(myhash.contains(point)){
				System.out.println("hash table already contains points: " + point.x + ", " + point.y);
				return false;
			}
			else{
			]

			// This is the bulk of the work for the function, after we have checked to see if the point is in the
			// point is in our Hashset, if it isn't we are going to add it, and the 8 valid moves for
			// a knight to move on a chessboard.
			// Now when our for loop iterates back to the contains point if statement its checking to see if
			// it is hitting any of this point, if it does clearly the answer is false.
			myhash.add(point);
			//System.out.println("current point: " + "x =  "  + point.x + ", " + "y = " + point.y);
			Point point1 = new Point(x + 1, y - 2);
			//System.out.println("x =  "  + point1.x + ", " + "y = " + point1.y);
			Point point2 = new Point(x - 1, y + 2);
			//System.out.println("x =  "  + point2.x + ", " + "y = " + point2.y);
			Point point3 = new Point(x + 1, y + 2);
			//System.out.println("x =  "  + point3.x + ", " + "y = " + point3.y);
			Point point4 = new Point(x - 1, y - 2);
			//System.out.println("x =  "  + point4.x + ", " + "y = " + point4.y);
			Point point5 = new Point(x + 2, y - 1);
			//System.out.println("x =  "  + point5.x + ", " + "y = " + point5.y);
			Point point6 = new Point(x - 2, y + 1);
			//System.out.println("x =  "  + point6.x + ", " + "y = " + point6.y);
			Point point7 = new Point(x + 2, y + 1);
			//System.out.println("x =  "  + point7.x + ", " + "y = " + point7.y);
			Point point8 = new Point(x - 2, y - 1);
			//System.out.println("x =  "  + point8.x + ", " + "y = " + point8.y);

			myhash.add(point1);
			myhash.add(point2);
			myhash.add(point3);
			myhash.add(point4);
			myhash.add(point5);
			myhash.add(point6);
			myhash.add(point7);
			myhash.add(point8);

			}
		}
		// We made it all the way through the for loop with no collison!!!!
		return true;
	}

	public static double difficultyRating()
	{
		return 3.0;
	}

	public static double hoursSpent()
	{
		return 15.0;
	}
/*
	public static void main(String args[])
	{

	String s = "a";
	String t = "abc";
	String st = "ab12";

	int first_res = baseConversion(s);
	int second_res = baseConversion(t);
	int third_res = baseConversion(st);
	System.out.println(s + " = " + first_res);
	System.out.println(t + " = " + second_res);
	System.out.println(st + " = " + third_res);


	ArrayList<String> list = new ArrayList<>();


	list.add("e4");
	list.add("a13");
	list.add("b23");
	list.add("d43");
	list.add("b13");
	list.add("a53");
	list.add("e53");
	list.add("e53");
	list.add("b43");
	list.add("c13");
	list.add("e3");



	allTheKnightsAreSafe(list, 5);


	}
*/


}
