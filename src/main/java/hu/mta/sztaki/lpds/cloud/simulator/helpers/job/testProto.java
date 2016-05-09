package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

import hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.GenericTraceProducer;
import hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.TraceManagementException;
import hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.file.GWFReader;

import java.io.File;
import java.util.*;

public class testProto {
	
	public static ArrayList<Job> list; 
	public static String[] type={"miliSecs","Secs","Min"};
	public static int jobDarab;
	
	public static void readJob(int db,List<Job> preJob){
		list=new ArrayList<>(db);
		JobPrototyper.setType(type[1]);
		
		for(int i=0;i<db;i++){
			Job j=JobPrototyper.makeJob(preJob.get(i));
			list.add(j);
		}
	}
	
	public static void testingJob(ArrayList<Job> list){
		for(Job temp:list){
			System.out.println(temp.getSubmittime());
		}
	}
	
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, TraceManagementException{
		GenericTraceProducer producer=null;
		String fileName="example";
		if (new File(fileName).exists()) 
			producer = new GWFReader(fileName,0,jobDarab,false,null);
		List<Job> jobs = producer.getAllJobs();
		
		//raw/pre jobs by TraceProducer -> convert/make to final jobs 
		readJob(jobDarab,jobs);
		testingJob(list);
	}
	
}
