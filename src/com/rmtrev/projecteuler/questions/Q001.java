package com.rmtrev.projecteuler.questions;

/**
 * <b>Multiples of 3 and 5</b>
 * 
 * <p>If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.</p>
 * 
 * <p>Find the sum of all the multiples of 3 or 5 below 1000.</p>
 * 
 * @author rmt
 *
 */
public class Q001 implements IQuestion
{
	public void Run(String[] args) throws Exception
	{
		int sum = 0;
		
		for(int i = 0; i < 1000; i++)
		{
			if(i % 3 == 0 || i % 5 == 0)
			{
				sum += i;
			}
		}
		
		System.out.println(Integer.toString(sum));
	}
}
