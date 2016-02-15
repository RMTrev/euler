package com.rmtrev.projecteuler.level04;

import com.rmtrev.projecteuler.interfaces.ILevel;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class Level04 implements ILevel
{

	@Override
	public void ExecuteProblem(int number, String[] args) throws Exception
	{
		IProblem p;
		
		switch(number)
		{
		case 94:
			p = new P094();
			break;
		default:
			System.out.println("Unknown or unimplemented question number: " + args[0]);
			return;
		}
		
		p.Run(args);
	}

}
