package hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.file;

import hu.mta.sztaki.lpds.cloud.simulator.helpers.job.Job;

import java.lang.reflect.InvocationTargetException;

public class BitbrainReader extends TraceFileReaderFoundation implements ReaderStrategy{

	public BitbrainReader(String fileName, int from, int to,
			   		       boolean allowReadingFurther, Class<? extends Job> jobType)
			             throws SecurityException, NoSuchMethodException{
		super("Bitbrain", fileName, from, to, allowReadingFurther, jobType);
	}

	@Override
	public boolean isTraceLine(String line) {
		return basicTraceLineDetector(";\t", line);
	}

	@Override
	protected Job createJobFromLine(String line)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		final String[] fragments = line.trim().split("\\s+");
		Job j=jobCreator.newInstance();
		j.setAllParam(
				// id:
				fragments[0],
				// submit time in secs:
				Long.parseLong(fragments[0]),
				// wait time in secs:
				(long)0,//Long.parseLong(fragments[2]), ?
				// run time in secs:
				(long)0,//Long.parseLong(fragments[3]), ?
				// allocated processors:
				Integer.parseInt(fragments[2]),
				// average cpu time:
				Double.parseDouble(fragments[3]), 
				// average memory: ?
				(long)Integer.parseInt(fragments[7]),
				// userid:
				"USER",	
				// groupid:
				"GROUP",
				// execid:
				"EXEC",
				// preceeding job
				null, 
				(long)0);
		return j;
	
	/* 
	 * Giving propertys at the website:
	 * 1.Timestamp: number of milliseconds since 1970-01-01.
	   2.CPU cores: number of virtual CPU cores provisioned.
	   3.CPU capacity provisioned (CPU requested): the capacity of the CPUs in terms of MHZ, it equals to number of cores x speed per core.
	   4.CPU usage: in terms of MHZ.
	   5.CPU usage: in terms of percentage
	   6.Memory provisioned (memory requested): the capacity of the memory of the VM in terms of KB.
	   7.Memory usage: the memory that is actively used in terms of KB.
	   8.Disk read throughput: in terms of KB/s
	   9.Disk write throughput: in terms of KB/s
	   10.Network received throughput: in terms of KB/s
	   11.Network transmitted throughput: in terms of KB/s
	 */
		
	}

}
