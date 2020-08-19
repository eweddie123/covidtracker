package tracker;

import java.util.*;

public class UserInteraction {
	
	private int userId;
	private int contactId;
	private boolean maskOn;
	private boolean largeGathering;
	private Date time;
	
	public UserInteraction(int userId, int contactId, Date time) {
		this.userId = userId;
		this.contactId = contactId;
		this.time = time;
	}
	
	public void setMaskOn(boolean bool) {
		this.maskOn = bool;
	}
	
	public boolean getMaskOn() {
		return maskOn;
	}
	
	public Date getTime() {
		return time;
	}
	
	/*public UserAccount getContact() {
		return contact;
	}*/
}
