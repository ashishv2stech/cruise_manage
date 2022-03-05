package Exam.Cruise_booking_system;

public class AllData {
	
	String cust_id,cust_name,cust_email;
	
	public AllData(String a,String b,String c) {
		this.cust_id=a;
		this.cust_name=b;
		this.cust_email=c;
		
	}

	
	public String getCust_id() {
		return cust_id;
	}


	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}


	public String getCust_name() {
		return cust_name;
	}


	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}


	public String getCust_email() {
		return cust_email;
	}


	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}


	

}
