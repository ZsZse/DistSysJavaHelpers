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
	
	public static ReaderContext useStr(String fileName, int from, int to,boolean aRF) throws Exception{
		ReaderContext rco;
		String[] fileN=fileName.split("\\s+");
		
		switch(fileN[1]){
			case "gwa":
				rco=new ReaderContext(new BitbrainReader(fileName,from,to,aRF));
				break;
			case "swf":
				rco=new ReaderContext(new SWFReader(fileName,from,to,aRF));
				break;
			case "one":
				rco=new ReaderContext(new One2HistoryReader(fileName,from,to,aRF));
				break;
			default:
				rco=new ReaderContext(new GWFReader(fileName,from,to,aRF));
				break;
		}
		
		return rco;

	} 

}
