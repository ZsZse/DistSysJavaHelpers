package hu.mta.sztaki.lpds.cloud.simulator.helpers.trace.file;

import java.util.*;

public class UniRead {
	
	public List<? extends TraceFileReaderFoundation> r0;
	private TraceFileReaderFoundation r1=null;
	private PreziReader pr;
	
	public UniRead(String filename){
		pr=new PreziReader(filename,0,1,true,null);
		r0.add(0,r1);
	}
	
	public void addStrategy(){}
	public void dropStrategy(){}
	public void getAllStrategy(){}
	
	public void create(){
	//just planning for the creation decision
		switch(){
			case 1: break;
			case 2: break;
			case 3: break;
			default: break;
		}
		
	}
	
}
