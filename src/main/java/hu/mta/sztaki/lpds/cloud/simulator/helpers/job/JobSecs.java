package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

public class JobSecs extends Job{
	
	public JobSecs(String id, long submit, long queue, long exec, int nprocs,
		      double ppCpu, long ppMem, String user,
		      String group, String executable, Job preceding, long delayAfter){
	
		super(id,submit,queue,exec,nprocs,ppCpu,ppMem,
				user,group,executable,preceding,delayAfter);	
	
		type="Seconds";
	}

	public long getExectimeSec() {
		return getExectime();
	}
	public long getQueuetimeSec() {
		return getQueuetime();
	}
	public long getStoptimeSec() {
		return getStoptime();
	}
	public long getSubmittimeSec() {
		return getSubmittime();
	}
	public long getStartTimeInstanceSec() {
		return getStartTimeInstance();
	}
	public long getMidExecInstanceSec() {
		return getMidExecInstance();
	}
	
	public void started(){}
	public void completed(){}

}
