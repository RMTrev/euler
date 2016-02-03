package com.rmtrev.projecteuler.questions;

import java.math.BigInteger;

import com.rmtrev.projecteuler.common.MathPlus;

/**
 * <b>Lattice paths</b>
 * 
 * @author rmt
 *
 */
public class Q015 implements IQuestion
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
