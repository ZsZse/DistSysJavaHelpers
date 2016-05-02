package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

import java.util.*;

public class testProto {
	
	public static ArrayList<Job> list; 
	public static String[] type={"miliSecs","Secs","Min"};
	public static int jobDarab;
	public static long[] sampleSubmitTime;
	
	public static void loadMakingParameters(){
		jobDarab=10;
		sampleSubmitTime=new long[jobDarab];	
		sampleSubmitTime[0]=1220227200; //Secs
		sampleSubmitTime[1]=1220227200*1000; //miliSecs
		sampleSubmitTime[2]=122022720; //Min;
		sampleSubmitTime[3]=1220227200;
		sampleSubmitTime[4]=1220227200*1000;
		sampleSubmitTime[5]=122022720;
		sampleSubmitTime[6]=122022720;
		sampleSubmitTime[7]=1220227200;
		sampleSubmitTime[8]=1220227200*1000;
		sampleSubmitTime[9]=122022720;
	}
	
	public static void readJob(int db){
		list=new ArrayList<>(db);
		for(int i=0;i<db;i++){
			Job j=JobPrototyper.makeJob(type[0],sampleSubmitTime[i]);
			list.add(j);
		}
	}
	
	public static void testingJob(ArrayList<Job> list){
		for(Job temp:list){
			System.out.println(temp.getSubmittime());
		}
	}
	
	public static void main(String[] args){
		JobPrototyper.loadJobMap();
		loadMakingParameters();
		readJob(jobDarab);
		testingJob(list);
		//char[] c=(Long.toString(sampleSubmitTime[1])).toCharArray();
		//System.out.println(c.length);
		//System.out.println(sampleSubmitTime[0]*1000);
	}

}
