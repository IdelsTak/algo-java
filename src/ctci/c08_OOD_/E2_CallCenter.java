/*
TODO: how to add callback in java;

TODO: tobe improved:

1. synchronization
2. there should be two threads:
	1) wait for the call to come
	2) consume the calls
	it's like service/consumer application
 */

package t08_OOD_;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E2_CallCenter {
	private final  Queue<Responder> responders= new LinkedList<>();	
	/*
	Employee Class
	*/
	public class Responder{
	
		boolean isFree = true;
		Responder superVisor;
		
		public Responder(Responder superVisor){
			this.superVisor = superVisor;
			responders.add(this);
		}
		
		public boolean getFree(){
			return isFree;
		}
		
		public void setFree(boolean isFree){
			this.isFree = isFree;
		}
		
		public boolean Handle(Call c){
			boolean callHandledSuccessfully = true;
			return callHandledSuccessfully;
		}
	}
	
	public class Manager extends Responder{

		public Manager(Responder superVisor) {
			super(superVisor);
		}
	}
	
	public class Director extends Responder{

		public Director(Responder superVisor) {
			super(superVisor);
		}
	}
	
	/*
	Call class
	*/	
	public class CallHandler implements Runnable{
		Responder responder;
		Call c;
		boolean callHandled;
		public CallHandler(Responder r, Call c){
			this.responder = r;
			this.c = c;
		}
		
		@Override
		public void run() {
			callHandled = responder.Handle(c);
		}
	}
		
	public class Call{}
	
	
	/*
	Functions
	*/
	public void dispatch(){
		Call c = getNextCall();
		while(null != c){
			(new CallHandler(getNextResponder(), c)).run();
			c = getNextCall();
		}
	}
	
	
	private Call getNextCall(){
		return new Call();
	}
	
	//TODO: handle waiting issue
	private Responder getNextResponder(){
		for(Responder r : responders){
			if(r.getFree()){
				r.setFree(false);
				return r;
			}
		}
		return null;
	}
	
	@Test
	public void aTest(){
		dispatch();
	}
}
