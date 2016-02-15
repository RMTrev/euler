package com.rmtrev.projecteuler.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordParser
{
	public static ArrayList<String> parseFile(File inputFile) throws Exception
	{
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
		
		return names;
	}
	
	private static Exception generateParseException(int state, char c)
	{
		return new Exception("Unexpected character in state " + Integer.toString(state) + ": " + c);
	}
}
