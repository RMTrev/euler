package com.rmtrev.projecteuler.questions;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Q067 implements IQuestion
{

	@Override
	public void Run(String[] args) throws Exception
	{
		if(args.length < 2)
		{
			System.out.println("Expected file parameter.");
			return;
		}
		
		File inputFile;
		File argFile = new File(args[1]);
		if(argFile.isAbsolute())
		{
			inputFile = argFile;
		}
		else
		{
			String curPath = System.getProperty("user.dir");
			File curDir = new File(curPath);
			File dataDir = new File(curDir, "data");
			inputFile = new File(dataDir, args[1]);
		}
		
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
