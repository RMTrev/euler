package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.interfaces.IProblem;

/**
 * <b>Special Pythagorean triplet</b>
 * 
 * <p>A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,</p>
 * <p><i>a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup></i></p>
 * 
 * <p>For example, 32 + 42 = 9 + 16 = 25 = 52.</p>
 * 
 * <p>There exists exactly one Pythagorean triplet for which a + b + c = 1000.</p>
 * <p>Find the product abc.</p>
 * 
 * @author rmt
 *
 */
public class P009 implements IProblem
{
	private static int LIMIT = 1000;

	@Override
	public void Run(String[] args) throws Exception
	{
		for(int c = LIMIT; c >= 3; c--)
		{
			for(int b = LIMIT - (c + 1); b >= 2; b--)
			{
				int a = LIMIT - (b + c);
				
				if((a*a + b*b) == (c*c))
				{
					System.out.println(Long.toString(a*b*c));
					return;
				}
			}
		}
	}

}
