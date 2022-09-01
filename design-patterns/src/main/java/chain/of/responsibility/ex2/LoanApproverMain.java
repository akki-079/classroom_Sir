package chain.of.responsibility.ex2;

abstract class LoanApprover {
	protected double baseAmount = 10000;
	LoanApprover successor;

	public void setSuccessor(LoanApprover successor) {
		this.successor=successor;
	}
	public abstract void approveLoan(double amount);
}


class Clerk extends LoanApprover{

	@Override
	public void approveLoan(double amount) {
		if(amount<baseAmount) {
			System.out.println("Your Loan Approved..");
		}else if(successor!=null) {
			System.out.println("Request sent to Manager");
			successor.approveLoan(amount);
		}
	}
	
}

class Manager extends LoanApprover{

	@Override
	public void approveLoan(double amount) {
		if(amount<baseAmount*5) {
			System.out.println("Your Loan Approved..");
		}else if(successor!=null) {
			System.out.println("Request sent to Director");
			successor.approveLoan(amount);
		}
	}
	
}

class Director extends LoanApprover{

	@Override
	public void approveLoan(double amount) {
		if(amount<baseAmount*10) {
			System.out.println("Your Loan Approved..");
		}else if(successor!=null) {
			System.out.println("Request sent to President");
			successor.approveLoan(amount);
		}
	}
	
}

class President extends LoanApprover{

	@Override
	public void approveLoan(double amount) {
		if(amount<baseAmount*20) {
			System.out.println("Your Loan Approved..");
		}else {
			System.out.println("Request needs a Board meeting");
		}
	}
	
}
public class LoanApproverMain {

	public static void main(String[] args) {

		Clerk clerk= new Clerk();
		Manager manager=new Manager();
		Director director=new Director();
		President president= new President();
		
		clerk.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(president);
		
		clerk.approveLoan(780000);
	}

}
