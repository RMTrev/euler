package com.rmtrev.projecteuler.level01;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import com.rmtrev.projecteuler.common.WordParser;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P022 implements IProblem
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
