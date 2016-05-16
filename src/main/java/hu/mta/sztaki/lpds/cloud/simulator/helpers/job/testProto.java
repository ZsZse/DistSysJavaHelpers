package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

import hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.GenericTraceProducer;
import hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.TraceManagementException;
import hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.file.GWFReader;

import java.io.File;
import java.util.*;

public class testProto {
	
	public static String[] type={"miliSecs","Secs","Min"};
	public static int jobDarab;
	
	public static void testingJob(ArrayList<Job> list){
		for(Job temp:list){
			System.out.println(temp.getSubmittime());
		}
	}
	
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, TraceManagementException{
		//using JobPrototyper to set the wanted type 
		JobPrototyper.setType(type[1]);
		GenericTraceProducer producer=null;
		
		//create a ReaderContext to using reader strategy
		String fileName="example";
		ReaderContext rc=StrategyClient.useStr(fileName,0,jobDarab,false);
		
		//finally make the producer with one wanted type and the right reader
		producer=rc.getReader();
		
		List<Job> jobs = producer.getAllJobs();
		
		testingJob(jobs);
	}
	
}
