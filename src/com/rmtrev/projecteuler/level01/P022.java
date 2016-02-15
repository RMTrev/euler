package com.rmtrev.projecteuler.level01;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF8"));
		char[] buf = new char[1024];
		int bytesRead = reader.read(buf);
		int state = 0;
		
		ArrayList<String> names = new ArrayList<String>();
		String curName = "";
		
		// simple parser
		// this is just a 3 state finite state machine
		while(bytesRead > 0)
		{
			for(int pos = 0; pos < bytesRead; pos++)
			{
				char c = buf[pos];
				
				switch(state)
				{
				case 0:
					if(c == '"')
					{
						state = 1;
					}
					else
					{
						throw generateParseException(state, c);
					}
					break;
					
				case 1:
					if(Character.isAlphabetic(c))
					{
						curName += c;
					}
					else if(c == '"')
					{
						state = 2;
						names.add(curName);
						curName = "";
					}
					else
					{
						throw generateParseException(state, c);
					}
					break;
					
				case 2:
					if(c == ',')
					{
						state = 0;
					}
					else
					{
						throw generateParseException(state, c);
					}
					break;
				
				default:
					throw new Exception("Unknown state number");
				}
			}
			
			bytesRead = reader.read(buf);
		}
		
		reader.close();
		
		if(state != 2)
		{
			throw new Exception();
		}
		
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
	
	private Exception generateParseException(int state, char c)
	{
		return new Exception("Unexpected character in state " + Integer.toString(state) + ": " + c);
	}

}
