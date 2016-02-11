package com.rmtrev.projecteuler.main;

import com.rmtrev.projecteuler.questions.*;

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
		
		IQuestion q;
		
		switch(qNum)
		{
		case 1:
			q = new Q001();
			break;
		case 2:
			q = new Q002();
			break;
		case 3:
			q = new Q003();
			break;
		case 4:
			q = new Q004();
			break;
		case 5:
			q = new Q005();
			break;
		case 6:
			q = new Q006();
			break;
		case 7:
			q = new Q007();
			break;
		case 8:
			q = new Q008();
			break;
		case 9:
			q = new Q009();
			break;
		case 10:
			q = new Q010();
			break;
		case 11:
			q = new Q011();
			break;
		case 12:
			q = new Q012();
			break;
		case 13:
			q = new Q013();
			break;
		case 14:
			q = new Q014();
			break;
		case 15:
			q = new Q015();
			break;
		case 16:
			q = new Q016();
			break;
		case 17:
			q = new Q017();
			break;
		case 18:
			q = new Q018();
			break;
		case 19:
			q = new Q019();
			break;
		case 20:
			q = new Q020();
			break;
		case 21:
			q = new Q021();
			break;
		case 22:
			q = new Q022();
			break;
		case 23:
			q = new Q023();
			break;
		case 24:
			q = new Q024();
			break;
		case 25:
			q = new Q025();
			break;
		case 26:
			q = new Q026();
			break;
		case 27:
			q = new Q027();
			break;
		case 28:
			q = new Q028();
			break;
		case 29:
			q = new Q029();
			break;
		case 30:
			q = new Q030();
			break;
		case 31:
			q = new Q031();
			break;
		case 32:
			q = new Q032();
			break;
		case 33:
			q = new Q033();
			break;
		case 34:
			q = new Q034();
			break;
		case 35:
			q = new Q035();
			break;
		case 36:
			q = new Q036();
			break;
		case 67:
			q = new Q067();
			break;
		case 94:
			q = new Q094();
			break;
		default:
			System.out.println("Unknown or unimplemented question number: " + args[0]);
			return;
		}
		
		long startTime = System.nanoTime();
		try
		{
			q.Run(args);
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
