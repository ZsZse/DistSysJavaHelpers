package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

public class JobMin extends Job{
	
	public JobMin(){
		type="Minute";
	}
	
	public long getExectimeMin() {
		return getExectime();
	}
	public long getQueuetimeMin() {
		return getQueuetime();
	}
	public long getStoptimeMin() {
		return getStoptime();
	}
	public long getSubmittimeMin() {
		return getSubmittime();
	}
	public long getStartTimeInstanceMin() {
		return getStartTimeInstance();
	}
	public long getMidExecInstanceMin() {
		return getMidExecInstance();
	}
	
	public void started(){
		//..
	}
	public void completed(){
		//..
	}

}
