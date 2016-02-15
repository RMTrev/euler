package com.rmtrev.projecteuler.main;

import com.rmtrev.projecteuler.interfaces.ILevel;
import com.rmtrev.projecteuler.level01.Level01;
import com.rmtrev.projecteuler.level02.Level02;
import com.rmtrev.projecteuler.level03.Level03;
import com.rmtrev.projecteuler.level04.Level04;

public class Main
{
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("USAGE: Q# [args ...]");
			return;
		}
		
		int qNum;
		try
		{
			qNum = Integer.parseInt(args[0]);
		}
		catch (Exception e)
		{
			System.out.println("ERROR: Invalid input for question number: " + args[0]);
			return;
		}
		
		ILevel level;
		
		if(qNum <= 25)
		{
			level = new Level01();
		}
		else if(qNum <= 50)
		{
			level = new Level02();
		}
		else if(qNum <= 75)
		{
			level = new Level03();
		}
		else if(qNum <= 100)
		{
			level = new Level04();
		}
		else
		{
			System.out.println("Unknown or unimplemented question number: " + args[0]);
			return;
		}
		
		long startTime = System.nanoTime();
		try
		{
			level.ExecuteProblem(qNum, args);
			long endTime = System.nanoTime();
		
			System.out.println("Executed in " + Double.toString(Math.round((endTime - startTime) / 1000000D) / 1000D) + " seconds.");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
