import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;

public class EnvironmentTest {
  
  private Environment test;

  public EnvironmentTest() throws FileNotFoundException {
    test = new Environment();
  }
  
 @Test
 public void environmentConstructorTest() {
  ArrayList<NPC> teamTest = test.getTeam();
  ArrayList<NPC> sickTest = test.getSick();
  ArrayList<NPC> hireTest = test.getHire();
  ArrayList<NPC> populationTest = test.getPopulation();
  double budgetTest = test.getBudget();
  double progressTest = test.getProgress();
  double totalProgressTest = test.getTotalProgress();
  int timeTest = test.getTime();
  int deadlineTest = test.getDeadLine();
  assertEquals(teamTest, test.team);
  assertEquals(sickTest, test.sick);
  assertEquals(hireTest, test.hire);
  assertEquals(populationTest, test.population);
  assertEquals(budgetTest, test.budget, 1);
  assertEquals(progressTest, test.progress, 1);
  assertEquals(totalProgressTest, test.totalProgress, 1);
  assertEquals(timeTest, test.time);
  assertEquals(deadlineTest, test.deadline);
 }

 @Test
 public void getTeamTest() {
   assertEquals(test.getTeam(), test.team);
 }

 @Test
 public void getHireTest() {
  assertEquals(test.getHire(), test.hire);
 }

 @Test
 public void getSickTest() {
  assertEquals(test.getSick(), test.sick);
 }

 @Test
 public void getPopulationTest() {
  assertEquals(test.getPopulation(), test.population);
 }

 @Test
 public void getBudgetTest() {
  assertEquals(test.getBudget(), test.budget, 1);
 }

 @Test
 public void getTimeTest() {
  assertEquals(test.getTime(), test.time);
 }

 @Test
 public void getDeadLineTest() {
  assertEquals(test.deadline, test.getDeadLine());
 }

 @Test
 public void getProgressTest() {
  assertEquals(test.getProgress(), test.progress, 1);
 }

 @Test
 public void getTotalProgressTest() {
  assertEquals(test.getTotalProgress(), test.totalProgress, 1);
 }

 @Test
 public void hireTest() {
  assertTrue(test.hire(test.population.get(0)));
 }

 @Test
 public void test() {
  assertTrue(test.fire(test.team.get(0)));
 }

 @Test
 public void checkRecoverTest() {
  test.checkRecover();
  for(int x = 0; x < test.sick.size(); x++)
  {
   if(test.sick.get(x).getLeave() != true) {
     fail("Someone should have recovered");
   }
  }
 }

 @Test
 public void giveBreakTest() {
   ArrayList<NPC> sickTest = test.getSick();
   test.giveBreak(test.team.get(0));
   ArrayList<NPC> sickTest2 = test.getSick();
   assertFalse("Break failed.", sickTest2.indexOf(test.team.get(0)) == (double)sickTest.indexOf(test.team.get(0)));
 }

 @Test
 public void deacreaseBudgetTest() {
  double testBudget = test.budget;
  test.deacreaseBudget(1);
  assertEquals(testBudget, test.budget+1, 1);
 }

 @Test
 public void newHireTest() {
  ArrayList<NPC> hireTest = test.getHire();
  test.newHire();
  ArrayList<NPC> hireTest2 = test.getHire();
  assertFalse("New Hire failed.", hireTest2.equals(hireTest));
 }

 @Test
 public void updateTest() {
  double budgetTest = test.getBudget();
  double progressTest = test.getProgress();
  int timeTest = test.getTime();
  test.update();
  double budgetTest2 = test.getBudget();
  double progressTest2 = test.getProgress();
  int timeTest2 = test.getTime();
  assertFalse("Progress did not change.", progressTest2 == progressTest);
  assertFalse("Time did not change.", timeTest2 == timeTest);
  assertFalse("Budget did not change.", budgetTest2 == budgetTest);
 }
}
