package com.rmtrev.projecteuler.level01;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import com.rmtrev.projecteuler.common.IO;
import com.rmtrev.projecteuler.common.WordParser;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P022 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		String path;
		if(args.length < 2)
		{
			path = "data\\p022_names.txt";
		}
		else
		{
			path = args[1];
		}
		
		File inputFile = IO.getFileHandler(path);
		
		ArrayList<String> names = WordParser.parseFile(inputFile);
		
		Collections.sort(names);
		
		long result = 0;
		for(int i = 0; i < names.size(); i++)
		{
			String name = names.get(i);
			int multiplier = i + 1;
			
			int adjNameScore = nameScore(name) * multiplier;
			result += adjNameScore;
		}
		
		System.out.println(Long.toString(result));
	}
	
	private int nameScore(String name)
	{
		int ret = 0;
		
		for(int i = 0; i < name.length(); i++)
		{
			int c = (int)name.charAt(i);
			
			ret += c - 64;
		}
		
		return ret;
	}
}
