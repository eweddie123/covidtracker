package tracking;

import java.util.Date;

public class UserStatus {
	private Date start;
	private Date end;
	private String status;
	
	public UserStatus() {
		status = "new";
		start = new Date();
		// default 2 weeks end time for new users
		end = new Date(start.getTime() + 1209600000);
	}
	
	public void setGreen() {
		status = "green";
		start = new Date();
	}

	public void setAmber() {
		status = "amber";
		start = new Date();
		end = new Date(start.getTime() + 1209600000);
	}

	public void setRed() {
		status = "red";
		start = new Date();
		end = new Date(start.getTime() + 1209600000);
	}
	
	public void setCovid() {
		status = "covid";
	}
	
	public String getStatus() {
		return status;
	}
	
	public Date getStartDate() {
		return start;
	}
	
	public Date getEndDate() {
		return end;
	}
	
	public long getTimeLeft() {
		Date now = new Date();
		return Math.abs(end.getTime() - now.getTime());
	}
}
