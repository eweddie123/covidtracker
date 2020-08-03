package tracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import tracking.UserAccount;
import tracking.UserGraph;

public class UserGraphTester {
	private UserGraph userbase;
	
	@Before
	public void setUp() {
		userbase = UserGraph.getInstance();
	}		
	
	@Test
	public void testAddAccount() {
		userbase.addUserAccount(20, "Bob");
		UserAccount a = userbase.getUserAccount(20);
		assertNotNull(a);
		assertEquals(a.getID() == 20, true);
		userbase.addUserAccount(20, "James");
		assertEquals(userbase.getSize() == 1, true);
	}
	
	@Test
	public void testDeleteAccount() {
		userbase.deleteUserAccount(20);
		UserAccount a = userbase.getUserAccount(20);
		assertNull(a);
	}
}
