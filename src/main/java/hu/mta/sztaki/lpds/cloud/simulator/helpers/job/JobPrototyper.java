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
	
	public static String getJobType(Job j){
		return j.getType();
	}
	
	public static Job makeJob(String time){
		switch(time){
			case "MiliSecs":
				return (Job)JobPrototyper.getJobInstance("1");
			case "Secs":
				return (Job)JobPrototyper.getJobInstance("2");	
			case "Min":
				return (Job)JobPrototyper.getJobInstance("3");
			default: 
				return (Job)JobPrototyper.getJobInstance("2");
		}
		
	}
}
