import java.util.Scanner;
import java.util.Stack;

public class NQueens
{
	public static int n = 0;

	public static void main(String[] args)
	{
		System.out.println("Set N: ");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		kb.close();
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Node> queens = new Stack<Node>();
		
		Node point = new Node();
		
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				stack.push(j);
				if(isSafe(stack, j+1))
				{
					Node.setColumn(j);
					Node.setRow(i);
					queens.push(point);
				}
				else stack.pop();
			}
			printBoard(stack);
		}
	}
	
	public static boolean isSafe(Stack<Integer> stack, int p)
	{
		for(int i = 0; i < stack.size(); i++)
		{
			if(stack.get(i) == p) return false;
			if((stack.get(i) - p) == (stack.size() - i)) return false;
			if(p - stack.get(i) == stack.size() - i) return false;
		}
		return true;
	}
	
	public static void printBoard(Stack<Integer> stack)
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(j == stack.get(i)) System.out.print("Q");
				else System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}
}

