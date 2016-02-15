package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P018 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		int[][] triangle = new int[][] {
			new int[] {75},
			new int[] {95, 64},
			new int[] {17, 47, 82},
			new int[] {18, 35, 87, 10},
			new int[] {20, 04, 82, 47, 65},
			new int[] {19, 01, 23, 75, 03, 34},
			new int[] {88, 02, 77, 73, 07, 63, 67},
			new int[] {99, 65, 04, 28, 06, 16, 70, 92},
			new int[] {41, 41, 26, 56, 83, 40, 80, 70, 33},
			new int[] {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
			new int[] {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
			new int[] {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
			new int[] {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
			new int[] {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
			new int[] {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23}
		};
		
		for(int row = 1; row < triangle.length; row++)
		{
			int[] prevRow = triangle[row - 1];
			int[] curRow = triangle[row];
			
			for(int i = 0; i < curRow.length; i++)
			{
				if(i == 0)
				{
					curRow[i] += prevRow[i];
				}
				else if(i == curRow.length - 1)
				{
					curRow[i] += prevRow[i - 1];
				}
				else
				{
					int a = prevRow[i - 1];
					int b = prevRow[i];
					
					if(a > b)
					{
						curRow[i] += a;
					}
					else
					{
						curRow[i] += b;
					}
				}
			}
		}
		
		int[] lastRow = triangle[triangle.length - 1];
		int maximum = 0;
		for(int i = 0; i < lastRow.length; i++)
		{
			if(lastRow[i] > maximum)
			{
				maximum = lastRow[i];
			}
		}
		
		System.out.println(Integer.toString(maximum));
	}

}
