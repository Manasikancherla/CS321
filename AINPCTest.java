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
            assertTrue("Level must be between 3 to 6",3<=testEmployee.getLevel()&&testEmployee.getLevel()<=6);
            assertTrue("Salary must be between 20000.00 to 120000.00",20000.00<=testEmployee.getSalary() || testEmployee.getSalary()<=120000.00);
            assertTrue("Initially all employees must not be on leave",!testEmployee.getLeave());
        }
    }

    @Test
    public static void getNPCTest(ArrayList<NPC> npcList) {
        for(NPC testEmployee : npcList)
        {
            assertEquals("Name must be the one given", testEmployee.getName(), testEmployee.name);
            assertTrue("Enthusiasm must be between 1 to 6",0<=testEmployee.getEnthusiasm()&&testEmployee.getEnthusiasm()<=6 );
            assertTrue("Health must be between 30 to 100",30<=testEmployee.getHealth()&&testEmployee.getHealth()<=100);
            assertTrue("Level must be between 3 to 6",3<=testEmployee.getLevel()&&testEmployee.getLevel()<=6);
            assertTrue("Salary must be between 20000.00 to 120000.00",20000.00<=testEmployee.getSalary() || testEmployee.getSalary()<=120000.00);
            assertTrue("Initially all employees must not be on leave",!testEmployee.getLeave());

        }

    }

    @Test
    public static void getMagicTest(ArrayList<NPC> npcList)
    {
        for(NPC testEmployee : npcList)
            assertTrue("Magic number must be between 35 and 72",Tester.getMagic(testEmployee)>=35 || Tester.getMagic(testEmployee)<=72);
    }

    @Test
    public void getContributionTest() {

    }

    @Test
    public void increaseEnthusiasmTest() {
    }

    @Test
    public void decreaseEnthusiasmTest() {
    }

    @Test
    public void decayHealthTest() {
    }

    @Test
    public void decayHealth1Test() {
    }

    @Test
    public void recoverHealthTest() {
    }

    @Test
    public void recoverHealth1Test() {
    }

    @Test
    public void levelUpTest() {
    }

    @Test
    public void levelDownTest() {
    }

    @Test
    public void increaseSalaryTest() {
    }

    @Test
    public void decreaseSalaryTest() {
    }

    @Test
    public void getTotalSalaryTest() {
    }

    @Test
    public void evaluateEventTest() {
    }

    public static void main(String args[])
    {
        getNPCTest(Tester.getNPC());
        getMagicTest(Tester.getNPC());

    }
}
