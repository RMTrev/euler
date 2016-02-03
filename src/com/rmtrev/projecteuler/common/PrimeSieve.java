package com.rmtrev.projecteuler.common;

import java.util.Iterator;
import java.util.HashMap;

/**
 * Implementation of the Sieve of Eratosthenes that is unbounded
 * 
 * <p>Source: http://rosettacode.org/wiki/Sieve_of_Eratosthenes#Infinite_iterator_with_a_faster_algorithm_.28sieves_odds-only.29</p>
 * 
 * <p>Cleaned up code to make it more readable, as the original is impossible to follow.</p>
 * 
 * @author rmt
 *
 */
public class PrimeSieve implements Iterator<Long>
{
	long candidate = 2;
	Iterator<Long> baseprimes = null;
	long basep = 3;
	long basepsqr = 9;
	
	// HashMap of the sequences of non-primes
	// the hash map allows us to get the "next" non-prime reasonably quickly
	// but further allows re-insertions to take amortized constant time
	final HashMap<Long,Long> nonprimes = new HashMap<>();
	
	public boolean hasNext()
	{
		return true;
	}
	
	public Long next()
	{
		// do the initial primes separately to initialize the base primes sequence
		// RMT NOTE: This block is used for the first three calls of next().
		//           At the end of the third call, candidate will be 7.
		if (this.candidate <= 5L)
		{
			if (this.candidate++ == 2L)
			{
				return 2L; // RMT NOTE: candidate = 3
			}
			else
			{
				this.candidate++;
				if (this.candidate == 5L)
				{
					return 3L; // RMT NOTE: candidate = 5
				}
				else
				{
					this.baseprimes = new PrimeSieve();
					this.baseprimes.next();
					this.baseprimes.next(); // throw away 2 and 3
					return 5L;
				}
			}
		}
		
		// skip non-prime numbers including squares of next base prime
		// RMT NOTE: The first time reaching this block, candidate will equal 7. Because
		//           the inital value of basepsqr = 9, and nonprimes is empty, this block
		//           will not be entered.
		//           The second time, candidate = 9. After the block:
		//               basep = 5
		//               basepsqr = 25
		//               nonprimes[15] = 6 (15 = 3 * 3 + 6)
		//               candidate = 11
		for ( ; this.candidate >= this.basepsqr || //equals nextbase squared => not prime
				nonprimes.containsKey(this.candidate);
				candidate += 2)
		{
			// insert a square root prime sequence into hash map if to limit
			if (candidate >= basepsqr)
			{
				// if square of base prime, always equal
				long adv = this.basep << 1; // RMT NOTE: adv = basep * 2
				nonprimes.put(this.basep * this.basep + adv, adv);
				this.basep = this.baseprimes.next(); // RMT NOTE: basep will be 5 the first time reaching this line.
				this.basepsqr = this.basep * this.basep;
			}
			// else for each sequence that generates this number,
			// have it go to the next number (simply add the advance)
			// and re-position it in the hash map at an emply slot
			else
			{
				long adv = nonprimes.remove(this.candidate);
				long nxt = this.candidate + adv;
				while (this.nonprimes.containsKey(nxt)) nxt += adv; //unique keys
				this.nonprimes.put(nxt, adv);
			}
		}
		// prime
		long tmp = candidate; this.candidate += 2; return tmp;
	}
}
