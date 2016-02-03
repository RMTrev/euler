package com.rmtrev.projecteuler.common;

import java.util.Iterator;

public class CollatzIterator implements Iterator<Long>
{
	long _Current;
	
	public CollatzIterator(long start) throws Exception
	{
		if(start < 1)
		{
			throw new Exception("Starting number must be greater than or equal to 1");
		}
		_Current = start;
	}

	@Override
	public boolean hasNext()
	{
		if(_Current == 1)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public Long next()
	{
		if(!hasNext())
		{
			return 1L;
		}
		
		if(_Current % 2 == 0)
		{
			_Current = _Current / 2;
		}
		else
		{
			_Current = 3 * _Current + 1;
		}
		
		return _Current;
	}

}
