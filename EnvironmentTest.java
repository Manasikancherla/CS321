import java.junit.*;
import static org.junit.Assert.*;

public class EnvironmentTest {

 @Test
 public void environmentConstructorTest() {
  Environment test = new Environment();
  ArrayList<NPC> teamTest = game.getTeam();
  ArrayList<NPC> sickTest = game.getSick();
  ArrayList<NPC> hireTest = game.getHire();
  ArrayList<NPC> populationTest = game.getPopulation();
  double budgetTest = game.getBudget();
  double progressTest = game.getProgress();
  double totalProgressTest = game.getTotalProgress();
  int timeTest = game.getTime();
  int deadlineTest = game.getDeadLine();
  assertEquals(teamTest, team);
  assertEquals(sickTest, sick);
  assertEquals(hireTest, hire);
  assertEquals(populationTest, population);
  assertEquals(budgetTest, budget);
  assertEquals(progressTest, progress);
  assertEquals(totalProgressTest, totalProgress);
  assertEquals(timeTest, time);
  assertEquals(deadlineTest, deadline);
 }

 @Test
 public void getTeamTest() {
   assertEquals(game.getTeam(), team);
 }

 @Test
 public void getHireTest() {
  assertEquals(game.getHire(), hire);
 }

 @Test
 public void getSickTest() {
  assertEquals(game.getSick(), sick);
 }

 @Test
 public void getPopulationTest() {
  assertEquals(game.getPopulation(), population);
 }

 @Test
 public void getBudgetTest() {
  assertEquals(game.getBudget(), budget);
 }

 @Test
 public void getTimeTest() {
  assertEquals(game.getTime(), time);
 }

 @Test
 public void getDeadLineTest() {
  assertEquals(deadline, game.getDeadLine());
 }

 @Test
 public void getProgressTest() {
  assertEquals(game.getProgress(), progress);
 }

 @Test
 public void getTotalProgressTest() {
  assertEquals( game.getTotalProgress(), totalProgress);
 }

 @Test
 public void hireTest() {
  assertTrue(hire());
 }

 @Test
 public void test() {
  assertTrue(fire());
 }

 @Test
 public void checkRecoverTest() {
  checkRecover();
  for(int x = 0; x < sick.size(); x++)
		{
			if(sick.get(x).getLeave() != true) {
				 fail("Someone should have recovered");
			}
		}
 }

 @Test
 public void giveBreakTest() {
   ArrayList<NPC> sickTest = game.getSick();
   game.giveBreak(team.get(0));
   ArrayList<NPC> sickTest2 = game.getSick();
   assertNotEquals(sickTest2, sickTest);
 }

 @Test
 public void deacreaseBudgetTest() {
  assertEquals(deacreaseBudget(1), budget-1;
 }

 @Test
 public void newHireTest() {
  ArrayList<NPC> hireTest = game.getHire();
  newHire();
  ArrayList<NPC> hireTest2 = game.getHire();
  assertNotEquals(hireTest2, hireTest);
 }

 @Test
 public void updateTest() {
  double budgetTest = game.getBudget();
  double progressTest = game.getProgress();
  int timeTest = game.getTime();
  update();
  double budgetTest2 = game.getBudget();
  double progressTest2 = game.getProgress();
  int timeTest2 = game.getTime();
  assertNotEquals(progressTest2, progressTest);
  assertNotEquals(timeTest2, timeTest);
  assertNotEquals(budgetTest2, budgetTest);
 }
}
