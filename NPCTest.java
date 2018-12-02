import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NPCTest {

    private NPC tester = new NPC();

    public NPCTest() {
    }

    @Before
    public void createNPCfirst()
    {
        tester.setName("Tester");
        tester.setHealth(30);
        tester.setEnthusiasm(0);
        tester.setLeave(false);
        tester.setLevel(0);
        tester.setSalary(20000.00);
    }

    @Test
    public void Name() {
        assertEquals("Name must match (case-sensitive)",tester.name,tester.getName());
        assertSame("Name must be a string", tester.getName(), (String) tester.getName());
    }


    @Test
    public void Enthusiasm() {
        assertTrue("Enthusiasm must be an integer between 0 to 6",0<=tester.getEnthusiasm()&&tester.getEnthusiasm()<=6);
    }


    @Test
    public void Level() {
        assertTrue("Level must be an integer between 0 to 6",0<=tester.getLevel()&&tester.getLevel()<=6);
    }

    @Test
    public void Health() {
        assertTrue("Health must be an integer between 30 to 100",30<=tester.getHealth()&&tester.getHealth()<=100);
    }

    @Test
    public void Leave() {
        assertTrue("Leave must either be true or false",tester.getLeave()==true||tester.getLeave()==false);
    }

    @Test
    public void Salary() {
        assertTrue("Salary must be a double between 20,000 and 140,000",tester.getSalary()>=20000.00 && tester.getSalary()<=140000.00);
    }

}