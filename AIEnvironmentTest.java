
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AIEnvironmentTest {
	
	static AIEnvironment tester;
	ArrayList<String> eventTest;
	static{try {
		tester = new AIEnvironment();
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	}
	@Test
	public void updateTest()
	{
		ArrayList<String> eventList = tester.getEvents();
		assertTrue("Size of string must be 12",12==eventList.size());
		for(int i=0; i<eventList.size(); i++)
		{
		int percentage = Integer.parseInt(eventList.get(i).substring(6, 8));
		assertTrue("percentage must be between 10 to 20",10<=percentage && eventList.size()<=20);
		}
	}
	@Test
	public void runningTest()
	{
		assertTrue("Budget must be 1mil",tester.game.getBudget()== 1000000);
		assertTrue("Progress must be 100",tester.game.getProgress()== 100);
		assertTrue("Time must be 1",tester.game.getTime()== 1);
		assertTrue("deadLine",tester.game.getBudget()== 31);
		
	}
	
	@Test
	public void displayDeadLineTest()
	{
		int days = tester.game.getTimeframe()- tester.game.getTime();
		assertTrue("Days must be within 1~31", 1<=days && days <=31);
	}
	
		}
	@Test
	public void restTest()
	{
		Environment testE = tester.game;
		assertTrue("Must be true",testE.giveBreak(testE.getTeam().get(0)));
		assertEquals("Name have to be equal to Eric",testE.getSick().get(0).getName(),"Eric");
	}
	
	@Test
	public void hireTest()
	{
		Environment testE = tester.game;
		NPC testNPC = null;
		testNPC.setName("TEST");
		assertTrue("Must be true ",testE.hire(testNPC));
		assertEquals("Name has to be TEST ",testE.getTeam().get(4).getName(),"TEST");
	}
	
	@Test
	public void fireTest()
	{
		Environment testE = tester.game;
		assertTrue("Must be true ",testE.fire(testE.getTeam().get(0)));
		assertEquals("Name has to be Manasi ",testE.getTeam().get(0).getName(),"Manasi");
	}
	
}
