package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.interfaces.ILevel;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class Level01 implements ILevel
{

	@Override
	public void ExecuteProblem(int number, String[] args) throws Exception
	{
		IProblem p;
		switch(number)
		{
		case 1:
			p = new P001();
			break;
		case 2:
			p = new P002();
			break;
		case 3:
			p = new P003();
			break;
		case 4:
			p = new P004();
			break;
		case 5:
			p = new P005();
			break;
		case 6:
			p = new P006();
			break;
		case 7:
			p = new P007();
			break;
		case 8:
			p = new P008();
			break;
		case 9:
			p = new P009();
			break;
		case 10:
			p = new P010();
			break;
		case 11:
			p = new P011();
			break;
		case 12:
			p = new P012();
			break;
		case 13:
			p = new P013();
			break;
		case 14:
			p = new P014();
			break;
		case 15:
			p = new P015();
			break;
		case 16:
			p = new P016();
			break;
		case 17:
			p = new P017();
			break;
		case 18:
			p = new P018();
			break;
		case 19:
			p = new P019();
			break;
		case 20:
			p = new P020();
			break;
		case 21:
			p = new P021();
			break;
		case 22:
			p = new P022();
			break;
		case 23:
			p = new P023();
			break;
		case 24:
			p = new P024();
			break;
		case 25:
			p = new P025();
			break;
		default:
			System.out.println("Unknown or unimplemented question number: " + args[0]);
			return;
		}
		
		p.Run(args);
	}

}
