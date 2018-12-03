import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AINPCTest extends AINPC {

    static AINPC Tester;

    static {
        try {
            Tester = new AINPC();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static NPC testEmployee = new NPC();

    /**
     * Constructor for AINPC
     * This generates a set amount of randomized NPCs
     * The STATS of each NPC will be randomized along with a list of random names
     *
     * @throws FileNotFoundException
     */
    public AINPCTest() throws FileNotFoundException {
    }

    @Test
    public void createNPCTest(){
        for(int i=0;i<50;i++) {
            testEmployee = Tester.createNPC("test");
            assertEquals("Name must be the one given", testEmployee.getName(), "test");
            assertTrue("Enthusiasm must be between 1 to 6",0<=testEmployee.getEnthusiasm()&&testEmployee.getEnthusiasm()<=6 );
            assertTrue("Health must be between 30 to 100",30<=testEmployee.getHealth()&&testEmployee.getHealth()<=100);
            assertTrue("Level must be between 1 to 6",1<=testEmployee.getLevel()&&testEmployee.getLevel()<=6);
            assertTrue("Salary must be between 20000.00 to 120000.00",20000.00<=testEmployee.getSalary() || testEmployee.getSalary()<=120000.00);
            assertTrue("Initially all employees must not be on leave",!testEmployee.getLeave());
        }
    }

    @Test
    public void getNPCTest() {
        ArrayList<NPC> npcList = Tester.getNPC();
        for(NPC testEmployee : npcList)
        {
            assertEquals("Name must be the one given", testEmployee.getName(), testEmployee.name);
            assertTrue("Enthusiasm must be between 1 to 6",0<=testEmployee.getEnthusiasm()&&testEmployee.getEnthusiasm()<=6 );
            assertTrue("Health must be between 30 to 100",30<=testEmployee.getHealth()&&testEmployee.getHealth()<=100);
            assertTrue("Level must be between 1 to 6",1<=testEmployee.getLevel()&&testEmployee.getLevel()<=6);
            assertTrue("Salary must be between 20000.00 to 120000.00",20000.00<=testEmployee.getSalary() || testEmployee.getSalary()<=120000.00);
            assertTrue("Initially all employees must not be on leave",!testEmployee.getLeave());

        }

    }

    @Test
    public void getMagicTest()
    {
        ArrayList<NPC> npcList = Tester.getNPC();
        for (NPC testEmployee : npcList)
            assertTrue("Magic number must be between 3500 and 7200", Tester.getMagic(testEmployee) >= 3500 && Tester.getMagic(testEmployee) <= 7200);
    }

    @Test
    public void getContributionTest()
    {
        ArrayList<NPC> npcList = Tester.getNPC();
        assertTrue("Contribution of team must be between 1750 to 3550",Tester.getContribution(npcList)>=1750 && Tester.getContribution(npcList)<=3650);
    }

    @Test
    public void increaseEnthusiasmTest()
    {
        int test;
        ArrayList<NPC> npcList = Tester.getNPC();
        for (NPC testEmployee : npcList)
        {
            test = testEmployee.getEnthusiasm();
            Tester.increaseEnthusiasm(testEmployee);
            assertTrue("Enthusiasm must increase", testEmployee.getEnthusiasm() == test + 1 && testEmployee.getEnthusiasm()<=6);
        }

    }

    @Test
    public void decreaseEnthusiasmTest()
    {
        int test;
        ArrayList<NPC> npcList = Tester.getNPC();
        for (NPC testEmployee : npcList)
        {
            test = testEmployee.getEnthusiasm();
            Tester.decreaseEnthusiasm(testEmployee);
            assertTrue("Enthusiasm must decrease", testEmployee.getEnthusiasm() == test - 1 && testEmployee.getEnthusiasm()<=6);
        }
    }

    @Test
    public void levelUpTest()
    {
        int test;
        ArrayList<NPC> npcList = Tester.getNPC();
        for (NPC testEmployee : npcList)
        {
            test = testEmployee.getLevel();
            Tester.levelUp(testEmployee);
            assertTrue("Level must increase", testEmployee.getLevel() == test + 1 && testEmployee.getLevel()<=6);
        }
    }

    @Test
    public void levelDownTest()
    {
        int test;
        ArrayList<NPC> npcList = Tester.getNPC();
        for (NPC testEmployee : npcList)
        {
            test = testEmployee.getLevel();
            Tester.levelDown(testEmployee);
            assertTrue("Level must decrease", testEmployee.getLevel() == test - 1 && testEmployee.getLevel()<=6);
        }
    }

    @Test
    public void increaseSalaryTest()
    {
        double test;
        ArrayList<NPC> npcList = Tester.getNPC();
        for (NPC testEmployee : npcList)
        {
            test = testEmployee.getSalary();
            Tester.increaseSalary(testEmployee);
            assertTrue("Salary must increase", testEmployee.getSalary() >= test);
        }
    }

    @Test
    public void decreaseSalaryTest()
    {
        double test;
        ArrayList<NPC> npcList = Tester.getNPC();
        for (NPC testEmployee : npcList)
        {
            test = testEmployee.getSalary();
            Tester.decreaseSalary(testEmployee);
            assertTrue("Salary must decrease", testEmployee.getSalary() <= test && testEmployee.getSalary()>=1000);
        }
    }

    @Test
    public void getTotalSalaryTest()
    {
        ArrayList<NPC> npcList = Tester.getNPC();
        assertTrue("Total sum of salaries must exceed 1000",Tester.getTotalSalary(npcList)>=1000);

    }

}
