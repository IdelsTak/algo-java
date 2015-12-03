/*
 */

package ctci.c08_OOD_2;

import java.util.List;

/**
 *start 21:17
 * @author andy
 */
public class E2_CallCenter_bk {
	static public class CallHandler{
		private static CallHandler instance;
		
		/*3 levels of employees :respondents, managers, directors.*/
		private final int LEVELS = 3;
		
		/*Initialize 10 respondents, 4 managers and 2 directors*/
		private final int NUM_RESPONDENTS = 10;
		private final int NUM_MANAGERS = 4;
		private final int NUM_DIRECTORS = 2;
		
		/* List of employees, by level
		employeeLevels[0] = respondents
		employeeLevels[1] = managers
		employeeLevels[2] = directors
		*/
		List<List<Employee>> employeeLevels;
		
		/*queues for each call's rank*/
		List<List<Call>> callQueues;
		
		protected CallHandler(){/*...*/}
		
		/*get instance of singleton class*/
		public static CallHandler getInstance(){
			if(instance == null) instance = new CallHandler();
			return instance;
		}
		
		/*get the first available employee who can handle this call*/
		public Employee getHandlerForCall(Call call){
			/*...*/
			return null;
		}
		
		/*routes the call to an available employee, or save in an queue
		if no employee available*/
		public void dispatchCall(Caller caller){
			Call call = new Call(caller);
			dispatchCall(call);
		}

		/*routes the call to an available employee, or saves in a queue if no employee available*/
		private void dispatchCall(Call call) {
			/*try to route the call to an employee with minimal rank*/
			Employee emp = getHandlerForCall(call);
			if(emp != null){
				emp.receiveCall(call);
				call.setHandler(emp);
			}else{
				/*place the call into corresponding call queue according to its rank*/
				call.reply("please wait for free employee to reply");
				callQueues.get(call.getRank().getValue()).add(call);
			}
		}
		
		/*an employee got free. Look for a wainting call that emp. can serve.
		return true if we assigned a call, false otherwise*/
		public boolean assignCall(Employee emp){
			//...
			return true; //TODO;
		}
	}

	private static class Employee {
		private Call currentCall = null;
		protected Rank rank;
		
		public Employee() {
		}

		/* Start the conversation*/
		private void receiveCall(Call call) {		}
		/*the issue is resolved, finish the call*/
		public void callCompleted(){}
		/* the issue has not resolved, escalate the call, and assign a new call to the employee*/
		public void escalateAndReassign(){}
		/*assign a new call to an employee, if the employee is free*/
		public boolean assignNewCall(){return false;}//???
		public boolean isFree(){return currentCall == null;}
		public Rank getRank(){return rank;}		
	}
	
	public class Manager extends Employee{
		public Manager(){
			rank = Rank.Manager;
		}
	}
	
	public class Director extends Employee{
		public Director(){	
			rank = Rank.Director;			
		}		
	}
	private static class Call {
		private Rank rank;/*minimal rank of employee who can handle this call*/
		private Caller caller;/*person who is calling*/
		private Employee handler;/*employee who is handling call*/
		
		public Call() {
		}

		private Call(Caller caller) {
			rank = Rank.Responder;
		}

		private void setHandler(Employee emp) {
			handler = emp;
		}

		private void reply(String message) {
			
		}

		private Rank getRank() {
			return rank;
		}
		
		public void setRank(Rank r){rank = r;}
		public Rank incrementRank(){
			return null;//TODO
		}
		public void disconnect(){}
	}

	private static class Caller {

		public Caller() {
		}
	}//caller

	public enum Rank {
		Responder,
		Manager,
		Director;
		private int getValue() {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
	}//rank
}
