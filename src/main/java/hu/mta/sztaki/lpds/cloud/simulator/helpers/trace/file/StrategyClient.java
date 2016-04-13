package hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.file;

import java.lang.reflect.InvocationTargetException;

import hu.mta.sztaki.lpds.cloud.simulator.helpers.job.Job;

public class StrategyClient {
	
	public static void Strategyr() throws SecurityException, NoSuchMethodException,
	        IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		//Example for using some strategy
		ReaderContext rc=new ReaderContext(new BitbrainReader(null,0,0,false,null));
		Job j=rc.executeStrategy(null);
		
	}

}
