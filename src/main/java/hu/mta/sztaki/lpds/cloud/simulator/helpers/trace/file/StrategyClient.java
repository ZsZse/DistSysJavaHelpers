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
	
	public static void useStr(String fileType, 
				  String fN, int from, int to, boolean aRF, Class<? extends Job> jobType) throws Exception{
		ReaderContext rco;
		switch(fileType){
		case "GWA":
			rco=new ReaderContext(new BitbrainReader(fN,from,to,aRF,jobType));
			break;
		case "SWF":
			rco=new ReaderContext(new SWFReader(fN,from,to,aRF,jobType));
			break;
		case "ONE":
			rco=new ReaderContext(new One2HistoryReader(fN,from,to,aRF,jobType));
			break;
		}

	} 

}
