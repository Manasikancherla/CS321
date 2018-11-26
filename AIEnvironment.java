import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AIEnvironment{
	String events[];
	ArrayList<NPC> allNPC;
	Environment game;
	boolean active;
	/**
	 * Constructor for AIEnvironment
	 * @throws FileNotFoundException 
	 */
	public AIEnvironment() throws FileNotFoundException {
		/*
	 	Scanner to fill in events
		 */
		active = true;
		events = null;
		game = new Environment();
	}
	public boolean hire(String name) {
		NPC person = null;
		/*
		  	find the npc in allNPC
		 */
		return game.hire(person);	
	}
	public boolean fire(String name) {
		NPC person = null;
		/*
		  	find the npc in allNPC
		 */
		return game.fire(person);
	}
	public boolean rest(String name) {
		NPC person = null;
		/*
		  	find the npc in allNPC
		 */
		return game.giveBreak(person);
	}
	public int getTime() {
		return game.getTime();
	}
	public void displayBudget() {
		/*
		  	print out the budget;
		 */
		System.out.println("Budget: " + game.getBudget());
	}
	public void displayStats() {
		/*
		 	Some loop to print out all the stats of NPCs
		 	also print out the ones in the sick group
		 	use game.getTeam(); and npc.getStats
		 */
		ArrayList<NPC> employees = new ArrayList<NPC>();
		employees = game.getTeam();
		ArrayList<NPC> sickEmployees = new ArrayList<NPC>();
		sickEmployees = game.getSick();
		for (NPC npc : employees){
			npc.getStats();
		}
		for (NPC npc : sickEmployees){
			npc.getStats();
		}
	}
	public void displayTime() {
		/*
			Display the current time/day
			use game.getTime();
		 */
		System.out.println("DAY " + game.getTime());
	}
	public void displayTimeframe(){
		/*
			Display the time remaining to complete the project
		*/
		int daysPast = game.getTime();
		int totalTime = game.getTimeframe();
		System.out.println("Days Remaining: " + (totalTime-daysPast) + " days");
	}
	public void displayProgress() {
		/*
	 		print out the progress
	 		use game.getProgress();
		 */
		System.out.println("Total Progress: " + game.getProgress()/game.getTotalProgress() + "%");
	}
	public void displayHire() {
		/*
		 	print out a list of the candidates to be hired
		 	use game.getHire();
		 */
		ArrayList<NPC> toHire = new ArrayList<NPC>();
		toHire = game.getHire();
		for (NPC n : toHire){
			System.out.println(n.getName());
		}
	}
	public void displayTeam() {
		/*
		 print out a list of all the team members
		 */
		ArrayList<NPC> employees = new ArrayList<NPC>();
		employees = game.getTeam();
		for (NPC n : employees){
			System.out.println(n.getName());
		}
	}
	public void showBoost() {
		/*
		 	Show the three boost events you created
		 */
	}
	public boolean useBoost(int selection) {
		/*
		 Select the boost to use and call the event through evaluate
		 use game.triggerEvent(String);
		 also deduct the budget with game.decreaseBudget(double);
		 return false if you do not have enough money
		 selection will be from 1 to 3 inclusive
		 also print the effect when used
		 */
		return false;
	}
	public boolean running() {
		/*
		  checks if the game is running
		  change active when you finish the game or quit etc..
		 */
		return active;
	}
	public void update() {
		/*
		 	updates stuff also environment does half of it
		 	just trigger events and whatever that is left
		 	check if the game is complete
		 	use game.getProgress to get a value that decrease over time and use that to determine when the game is complete
		 */
		
		
		//This updates time, list of hire, everyone that is on the team and sick, budget, and progress
		game.update();	
	}	
}
