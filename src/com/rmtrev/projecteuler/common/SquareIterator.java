package com.rmtrev.projecteuler.common;

import java.util.Iterator;

public class SquareIterator implements Iterator<Long>
{
	private long _Next;
	
	public SquareIterator()
	{
		_Next = 1;
	}

	@Override
	public boolean hasNext()
	{
		return true;
	}

	@Override
	public Long next()
	{
		long sq = _Next * _Next;
		_Next++;
		return sq;
	}

}
