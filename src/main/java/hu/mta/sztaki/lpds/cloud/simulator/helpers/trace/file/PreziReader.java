package hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.file;

import java.lang.reflect.InvocationTargetException;

import hu.mta.sztaki.lpds.cloud.simulator.helpers.job.Job;

public class PreziReader extends TraceFileReaderFoundation{

	public PreziReader(String fileName, int from, int to,
					           boolean allowReadingFurther)
					           throws SecurityException, NoSuchMethodException{
		super("Prezi", fileName, from, to, allowReadingFurther);
		
	}
	
	@Override
	public boolean isTraceLine(String line) {
		return basicTraceLineDetector("#", line);
	}
	
	@Override
	protected Job createJobFromLine(String line)
		throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		final String[] fragments = line.trim().split("\\s+");
		
		long submittime = Long.parseLong(fragments[0]);
		long runtime = Long.parseLong(fragments[4]);
		
		return jobCreator.newInstance(fragments[1], //id
									                submittime,   //submit time
									                null,         //wait time ?
									                runtime,      //run time
									                1, -1, -1,    
									                "USER","GROUP","EXEC", null, 0);	
	}
}
