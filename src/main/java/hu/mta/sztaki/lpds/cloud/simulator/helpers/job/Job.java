package hu.mta.sztaki.lpds.cloud.simulator.helpers.job;

public abstract class Job implements Cloneable{
	
	private String id;
	protected String type;
	
	private long submittime;	  //Secs
	private long stoptime;
	private long exectime;
	private long midExecInstance;
	private long queuetime;
	private long starttime;
	
	public final int nprocs;
	public final double perProcCPUTime;
	public final long usedMemory;
	public final String user;
	public final String group;
	public final String executable;
	public final Job preceding;
	public final long thinkTimeAfterPreceeding;
	private long realqueueTime = -1;
	private long realstopTime = -1;
	private boolean ran = false;

	public Job(String id, long submit, long queue, long exec, int nprocs,
			   double ppCpu, long ppMem, String user,
			   String group, String executable, Job preceding, long delayAfter){
		
		this.id = id == null ? "" + this.hashCode() : id;
		submittime = submit;
		queuetime = queue;
		exectime = exec;
		stoptime = queuetime + exectime + submittime;
		starttime = submittime + queuetime;
		midExecInstance = starttime + exectime / 2;
		this.nprocs = nprocs;
		this.perProcCPUTime = ppCpu < 0 ? exec : ppCpu;
		this.usedMemory = ppMem;
		this.user = user;
		this.group = group;
		this.executable = executable;
		this.preceding = preceding;
		this.thinkTimeAfterPreceeding = delayAfter;
	}
	
	public String getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Job: " + id + " Submit Time: " + submittime + " Start Time: " + starttime + " Stop Time: "
				+ stoptime + " Procs: " + nprocs;
	}

	public long getExectime() {
		return exectime;
	}
	public long getQueuetime() {
		return queuetime;
	}
	public long getStoptime() {
		return stoptime;
	}
	public long getSubmittime() {
		return submittime;
	}
	public long getRealqueueTime() {
		return realqueueTime;
	}
	public long getRealstopTime() {
		return realstopTime;
	}
	public long getStartTimeInstance() {
		return starttime;
	}
	public long getMidExecInstance() {
		return midExecInstance;
	}

	public abstract void started();

	public abstract void completed();

	protected void setRan(boolean ran) {
		this.ran = ran;
	}
	protected void setRealqueueTime(long realqueueTime) {
		this.realqueueTime = realqueueTime;
	}
	protected void setRealstopTime(long realstopTime) {
		this.realstopTime = realstopTime;
	}

	public void adjust(long offset) throws IllegalStateException {
		if (!ran) {
			submittime += offset;  //Secs
			starttime += offset;
			stoptime += offset;
		} else {
			throw new IllegalStateException("Cannot adjust job if it has been ran already!");
		}
	}

	public boolean isOverlapping(final Job other) {
		return this.starttime <= other.starttime ? this.stoptime > other.starttime
				: other.stoptime > this.starttime;
	}
	
	public Object clone(){
		Object clone=null;
		try{
			clone=super.clone();
		}catch(Exception e){e.printStackTrace();}
		
		return clone;
	}
	
}
