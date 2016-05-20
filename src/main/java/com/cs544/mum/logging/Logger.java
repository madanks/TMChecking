package com.cs544.mum.logging;

public class Logger implements ILogger{

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("TMLOGGER").info(logstring);		
	}

}
