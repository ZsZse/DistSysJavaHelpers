package hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.file;

import java.lang.reflect.InvocationTargetException;

import hu.mta.sztaki.lpds.cloud.simulator.helpers.job.Job;

public class ReaderContext {
	
	private TraceFileReaderFoundation strategy;
	//private ReaderStrategy strategy;
	
	public ReaderContext(TraceFileReaderFoundation strategy){
		this.strategy=strategy;
	}
    
	//public void setReaderStrategy(..){..}
	
	public Job executeStrategy(String line)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		return strategy.createJobFromLine(line);
	}
	
	public TraceFileReaderFoundation getReader(){
		return this.strategy;
	}
}
