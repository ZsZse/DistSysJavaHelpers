package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

public class JobMiliSecs extends Job{
	
	public JobMiliSecs(){
		type="MiliSeconds";
	}

	public long getExectimeMiliSec() {
		return getExectime();
	}
	public long getQueuetimeMiliSec() {
		return getQueuetime();
	}
	public long getStoptimeMiliSec() {
		return getStoptime();
	}
	public long getSubmittimeMiliSec() {
		return getSubmittime();
	}
	public long getStartTimeInstanceMiliSec() {
		return getStartTimeInstance();
	}
	public long getMidExecInstanceMiliSec() {
		return getMidExecInstance();
	}
	
	public void started(){}
	public void completed(){}

}
