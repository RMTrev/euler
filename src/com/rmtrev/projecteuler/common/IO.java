package com.rmtrev.projecteuler.common;

import java.io.File;

public class IO
{
	public static File getFileHandler(String path)
	{
		File inputFile;
		File argFile = new File(path);
		if(argFile.isAbsolute())
		{
			inputFile = argFile;
		}
		else
		{
			String curPath = System.getProperty("user.dir");
			File curDir = new File(curPath);
			inputFile = new File(curDir, path);
		}
		
		return inputFile;
	}
}
