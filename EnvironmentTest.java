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

//To be implemented
 @Test
 public void checkRecoverTest() {
  checkRecover();
 }
//To be implemented
 @Test
 public void giveBreakTest() {

 }

 @Test
 public void deacreaseBudgetTest() {
  assertEquals(deacreaseBudget(1), budget-1;
 }

//to be implemented
 @Test
 public void newHireTest() {
  newHire();
  
 }
//to be implemented
 @Test
 public void triggerEventTest() {
  triggerEvent();
 }
//to be implemented
 @Test
 public void updateTest() {
  update();
 }

}