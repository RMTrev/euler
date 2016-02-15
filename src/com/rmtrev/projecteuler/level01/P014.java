package com.rmtrev.projecteuler.level01;

import java.util.HashMap;

import com.rmtrev.projecteuler.common.CollatzIterator;
import com.rmtrev.projecteuler.interfaces.IProblem;

/**
 * <b>Longest Collatz sequence</b>
 * 
 * <p>The following iterative sequence is defined for the set of positive integers:</p>
 * 
 * <p><i>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * </i></p>
 * 
 * <p>Using the rule above and starting with 13, we generate the following sequence:</p>
 * 
 * <p><i>13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1</i></p>
 * 
 * <p>It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.</p>
 * 
 * <p>Which starting number, under one million, produces the longest chain?</p>
 * 
 * <p>NOTE: Once the chain starts the terms are allowed to go above one million.</p>
 * 
 * @author rmt
 *
 */
public class P014 implements IProblem
{
	@Override
	public void Run(String[] args) throws Exception
	{
		long maxChainLength = 0;
		int maxChainStartNum = -1;
		
		HashMap<Integer, Long> map = new HashMap<Integer, Long>();
		
		for(int i = 1; i < 1000000; i++)
		{
			CollatzIterator iter = new CollatzIterator(i);
			long len = 0;
			while(iter.hasNext())
			{
				long l = iter.next();
				len++;
				
				if(map.containsKey(l))
				{
					len += map.get(l);
					break;
				}
			}
			
			map.put(i, len);
			
			if(len > maxChainLength)
			{
				maxChainLength = len;
				maxChainStartNum = i;
			}
		}
		
		System.out.println(Integer.toString(maxChainStartNum));
	}
}
