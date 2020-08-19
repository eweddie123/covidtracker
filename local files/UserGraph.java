package tracker;

import java.util.HashMap;

public class UserGraph {
	private int size;
	private static UserGraph graphInstance = null;
	public HashMap<Integer, UserAccount> users;
	
	private UserGraph() {
		users = new HashMap<Integer, UserAccount>();
	}
	
	public static UserGraph getInstance() {
		if(graphInstance == null) {
			graphInstance = new UserGraph();
		}
		return graphInstance;
	}
	
	public void addUserAccount(int id, String name) {
		UserAccount newAccount = new UserAccount(id, name);
		if(!users.containsKey(id)){
			users.put(id, newAccount);
			size++;
		}
	}
	
	public void deleteUserAccount(int id) {
		 users.remove(id);
		 size--;
	}
	
	public UserAccount getUserAccount(int id) {
		return users.get(id);
	}
	
	public int getSize() {
		return size;
	}
}
