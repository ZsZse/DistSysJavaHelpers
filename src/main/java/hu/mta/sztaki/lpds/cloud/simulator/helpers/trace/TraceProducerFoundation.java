package hu.mta.sztaki.lpds.cloud.simulator.helpers.trace;

import java.lang.reflect.Constructor;

import hu.mta.sztaki.lpds.cloud.simulator.helpers.job.Job;

public abstract class TraceProducerFoundation implements GenericTraceProducer {
	
	protected final Constructor<? extends Job> jobCreator;
	public static Class<? extends Job> jobType;

	public TraceProducerFoundation() throws NoSuchMethodException, SecurityException {
		jobCreator = jobType.getConstructor(String.class, long.class, long.class, long.class, int.class, double.class,
				long.class, String.class, String.class, String.class, Job.class, long.class);
	}
}
