package com.rmtrev.projecteuler.questions;

/**
 * <b>Sum square difference</b>
 * 
 * <p>The sum of the squares of the first ten natural numbers is,</p>
 * <p><i>1<sup>2</sup> + 2<sup>2</sup> + ... + 10<sup>2</sup> = 385</i></p>
 * 
 * <p>The square of the sum of the first ten natural numbers is,</p>
 * <p><i>(1 + 2 + ... + 10)<sup>2</sup> = 552 = 3025</i></p>
 * 
 * <p>Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.</p>
 * 
 * <p>Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.</p>
 * 
 * @author rmt
 *
 */
public class Q006 implements IQuestion
{
	@Override
	public void Run(String[] args) throws Exception
	{
		long sumOfSquares = 0;
		long sum = 0;
		
		for(int i = 1; i <= 100; i++)
		{
			sum += i;
			sumOfSquares += (i * i);
		}
		
		long answer = Math.abs((sum * sum) - sumOfSquares);
		
		System.out.println(Long.toString(answer));
	}
}
