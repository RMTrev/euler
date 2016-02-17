package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.interfaces.ILevel;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class Level02 implements ILevel
{

	@Override
	public void ExecuteProblem(int number, String[] args) throws Exception
	{
		IProblem p;
		
		switch(number)
		{
		case 26:
			p = new P026();
			break;
		case 27:
			p = new P027();
			break;
		case 28:
			p = new P028();
			break;
		case 29:
			p = new P029();
			break;
		case 30:
			p = new P030();
			break;
		case 31:
			p = new P031();
			break;
		case 32:
			p = new P032();
			break;
		case 33:
			p = new P033();
			break;
		case 34:
			p = new P034();
			break;
		case 35:
			p = new P035();
			break;
		case 36:
			p = new P036();
			break;
		case 37:
			p = new P037();
			break;
		case 38:
			p = new P038();
			break;
		case 39:
			p = new P039();
			break;
		case 40:
			p = new P040();
			break;
		case 41:
			p = new P041();
			break;
		case 42:
			p = new P042();
			break;
		case 43:
			p = new P043();
			break;
		case 44:
			p = new P044();
			break;
		case 45:
			p = new P045();
			break;
		case 46:
			p = new P046();
			break;
		case 47:
			p = new P047();
			break;
		case 48:
			p = new P048();
			break;
		default:
			System.out.println("Unknown or unimplemented question number: " + args[0]);
			return;
		}
		
		p.Run(args);
	}

}
