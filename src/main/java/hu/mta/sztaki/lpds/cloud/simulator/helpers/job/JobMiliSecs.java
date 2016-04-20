package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

public class JobMiliSecs extends Job{
	
	public JobMiliSecs(String id, long submit, long queue, long exec, int nprocs,
		      double ppCpu, long ppMem, String user,
		      String group, String executable, Job preceding, long delayAfter){
	
		super(id,submit,queue,exec,nprocs,ppCpu,ppMem,
				user,group,executable,preceding,delayAfter);	
	
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
