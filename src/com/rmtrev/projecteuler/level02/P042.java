package com.rmtrev.projecteuler.level02;

import java.io.File;
import java.util.ArrayList;

import com.rmtrev.projecteuler.common.IO;
import com.rmtrev.projecteuler.common.WordParser;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P042 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		String path;
		if(args.length < 2)
		{
			path = "data\\p042_words.txt";
		}
		else
		{
			path = args[1];
		}
		
		File inputFile = IO.getFileHandler(path);
		
		ArrayList<String> words = WordParser.parseFile(inputFile);
		
		int result = 0;
		
		for(int i = 0; i < words.size(); i++)
		{
			String word = words.get(i);
			
			if(isTriangleNumber(wordScore(word)))
			{
				result++;
			}
		}
		
		System.out.println(Integer.toString(result));
	}

	/**
	 * Returns true if the given number is a triangle number (ex: 1, 3, 6, 10, 15, ...)
	 * @param n
	 * @return
	 */
	private boolean isTriangleNumber(int n)
	{
		for(int i = 1; ;i++)
		{
			int triNum = (i * (i + 1)) / 2;
			if(n == triNum) return true;
			if(triNum > n) return false;
		}
	}

	private int wordScore(String name)
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
