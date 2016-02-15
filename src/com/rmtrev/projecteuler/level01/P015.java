package com.rmtrev.projecteuler.level01;

import java.math.BigInteger;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.interfaces.IProblem;

/**
 * <b>Lattice paths</b>
 * 
 * @author rmt
 *
 */
public class P015 implements IProblem
{
	private static int SIZE = 20;

	@Override
	public void Run(String[] args) throws Exception
	{
		BigInteger numerator = new BigInteger("1");
		for(int i = SIZE + 1; i <= SIZE * 2; i++)
		{
			numerator = numerator.multiply(BigInteger.valueOf(i));
		}
		
		long denominator = MathPlus.factorial(SIZE);
		
		BigInteger result = numerator.divide(BigInteger.valueOf(denominator));
		
		System.out.println(result.toString());
	}
}
