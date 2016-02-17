package com.rmtrev.projecteuler.level03;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import com.rmtrev.projecteuler.common.IO;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P067 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		String path;
		if(args.length < 2)
		{
			path = "data\\p067_triangle.txt";
		}
		else
		{
			path = args[1];
		}
		
		File inputFile = IO.getFileHandler(path);
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String line;
		long[] prevRow = null;
		while((line = reader.readLine()) != null)
		{
			String[] parts = line.split(" ");
			long[] curRow = new long[parts.length];
			
			for(int i = 0; i < parts.length; i++)
			{
				if(prevRow == null)
				{
					curRow[i] = Integer.parseInt(parts[i], 10);
				}
				else
				{
					int num = Integer.parseInt(parts[i], 10);
					
					if(i == 0)
					{
						curRow[i] = num + prevRow[i];
					}
					else if(i == curRow.length - 1)
					{
						curRow[i] = num + prevRow[i - 1];
					}
					else
					{
						long a = prevRow[i - 1];
						long b = prevRow[i];
						
						if(a > b)
						{
							curRow[i] = num + a;
						}
						else
						{
							curRow[i] = num + b;
						}
					}
				}
			}
			
			prevRow = curRow;
		}
		
		reader.close();
		
		long maximum = 0;
		for(int i = 0; i < prevRow.length; i++)
		{
			if(prevRow[i] > maximum)
			{
				maximum = prevRow[i];
			}
		}
		
		System.out.println(Long.toString(maximum));
	}

}
