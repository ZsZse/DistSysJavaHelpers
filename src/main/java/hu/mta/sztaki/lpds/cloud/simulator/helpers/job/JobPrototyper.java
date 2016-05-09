package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

import java.util.Hashtable;


public class JobPrototyper {

	private static Hashtable<String, Job> jobMap=new Hashtable<String,Job>();
	private static String type;
	
	public static Job getJobInstance(String id){
		Job mappedJob=jobMap.get(id);
		return (Job)mappedJob.clone();	
	}
	
	public static void loadJobMap(){
		JobSecs jms=new JobSecs();
		jobMap.put("0",jms);
		JobSecs js=new JobSecs();
		jobMap.put("1",js);
		JobMin jm=new JobMin();
		jobMap.put("2",jm);
	}
	
	public static void getJobfromMap(String id) throws Exception{
		Job clonedJob=(Job)JobPrototyper.getJobInstance(id);
		System.out.println("ExampleJob type: "+clonedJob.getType());
	}
	
	public static String getJobType(Job j){
		return j.getType();
	}
	
	public static void setType(String typ){
		type=typ;
		loadJobMap();
	}
	
	public static Job makeJob(Job preJob){
		long timeSample=preJob.getSubmittime();
		char[] c=(Long.toString(timeSample)).toCharArray();
		Job j;
		switch(time){
			case "miliSecs":
				if(c.length==10)timeSample*=1000;
				if(c.length==9)timeSample*=1000*60;
				j=(Job)JobPrototyper.getJobInstance("0");
				break;
			case "Secs":
				if(c.length==13)timeSample/=1000;
				if(c.length==9)timeSample*=60;
				j=(Job)JobPrototyper.getJobInstance("1");	
				break;
			case "Min":
				if(c.length==13)timeSample/=1000*60;
				if(c.length==10)timeSample/=60;
				j=(Job)JobPrototyper.getJobInstance("2");
				break;
			default: 
				if(c.length==13)timeSample/=1000;
				if(c.length==9)timeSample*=60;
				j=(Job)JobPrototyper.getJobInstance("1");
				break;
		}
		j.setSubmitTime(timeSample);
		return j;
	}
}
