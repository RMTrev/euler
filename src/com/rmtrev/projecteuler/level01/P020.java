package com.rmtrev.projecteuler.level01;

import java.math.BigInteger;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P020 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		BigInteger curNum = BigInteger.valueOf(1);
		for(int i = 1; i <= 100; i++)
		{
			curNum = curNum.multiply(BigInteger.valueOf(i));
		}
		
		String strNum = curNum.toString();
		
		long result = 0;
		for(int i = 0; i < strNum.length(); i++)
		{
			char c = strNum.charAt(i);
			if(Character.isDigit(c))
			{
				result += Character.digit(c, 10);
			}
		}
		
		System.out.println(Long.toString(result));
	}

}
