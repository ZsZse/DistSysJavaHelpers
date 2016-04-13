package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

import java.util.Hashtable;

public class JobPrototyper {

	private static Hashtable<String, Job> jobMap=new Hashtable<String,Job>();
	
	public static Job getJobInstance(String id){
		Job mappedJob=jobMap.get(id);
		return (Job)mappedJob.clone();	
	}
	
	//Testmethods for the prototype deign pattern
	public static void loadJobMap(){
		//JobMin jm=new JobMin(/*default*/);
		//jobMap.put(jm.getId(),jm);
	}
	
	public static void getJobfromMap(String id) throws Exception{
		Job clonedJob=(Job)JobPrototyper.getJobInstance(id);
		System.out.println("ExampleJob type: "+clonedJob.getType());
		
	}
}
