package com.rmtrev.projecteuler.level03;

import com.rmtrev.projecteuler.interfaces.ILevel;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class Level03 implements ILevel
{

	@Override
	public void ExecuteProblem(int number, String[] args) throws Exception
	{
		IProblem p;
		
		switch(number)
		{
		case 67:
			p = new P067();
			break;
		default:
			System.out.println("Unknown or unimplemented question number: " + args[0]);
			return;
		}
		
		p.Run(args);
	}

}
