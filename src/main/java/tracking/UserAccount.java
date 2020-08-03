package tracking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserAccount {
	private int ID;
	private LinkedList<UserInteraction> interactions;
	private HashSet<UserInteraction> twoWeeks;
	private UserStatus accountStatus;
	private String name;
	//private SimpleDateFormat sdf;
	
	public UserAccount(int idnum, String name) {
		ID = idnum;
		this.name = name;
		interactions = new LinkedList<UserInteraction>();
		twoWeeks = new HashSet<UserInteraction>();
		accountStatus = new UserStatus();
		//String timeFormat = "yyyy/MM/dd: hh/mm/ss";
		//SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		
	}
	
	public int getID() {
		return ID;
	}
	
	public UserStatus getAccountStatus() {
		return accountStatus;
	}
	
	/*public void addInteraction(int cont) {
		// retrieve UserAccount from Singleton graph
		UserAccount contact = UserGraph.getInstance().getUserAccount(cont);
		// point in time of adding interaction
		//UserInteraction interaction = new UserInteraction(contact, new Date());
		interactions.addFirst(interaction);
		twoWeeks.add(interaction);
	}*/
	
	public HashSet<UserInteraction> getTwoWeeks() {
		return twoWeeks;
	}
	/*
	public void updateRiskMap() {
		Date now = new Date();
		Date twoWeeksAgo = new Date(now.getTime() - 1209600000);
		for (UserInteraction ui: twoWeeks) {
			if (ui.getTime().before(twoWeeksAgo)) {
				twoWeeks.remove(ui);
			}
		}
	}
	*/
	//code for client side
	/*public void notifyCovid() {
		accountStatus.setCovid();
		for (UserInteraction ui : twoWeeks) {
			UserAccount contact = ui.getContact();
			contact.getAccountStatus().setRed();
			for (UserInteraction ui2 : contact.getTwoWeeks()) {
				UserAccount contact2 = ui2.getContact();
				UserStatus accountStatus2 = contact2.getAccountStatus();
				if (!accountStatus2.getStatus().equals("red") || !accountStatus2.getStatus().equals("covid")) {
					accountStatus2.setAmber();
				}
			}
		}
	}*/ 
}
