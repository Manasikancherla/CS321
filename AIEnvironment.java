import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AIEnvironment{
	ArrayList<String> events;
	ArrayList<NPC> allNPC;
	Environment game;
	boolean active;
	/**
	 * Constructor for AIEnvironment
	 * @throws FileNotFoundException 
	 */
	public AIEnvironment() throws FileNotFoundException {
		active = true;
		events = new ArrayList<String>();
		game = new Environment();
		allNPC = game.getPopulation();
		Scanner in = new Scanner(new File("events.txt"));
		while(in.hasNextLine())
		{
			in.nextLine();
			events.add(in.nextLine());
		}
		in.close();
	}
	
	public boolean hire(String name) {
		for(int i = 0; i<game.getHire().size(); i++)
		{
			if(game.getHire().get(i).getName().equals(name))
			{
				return game.hire(game.getHire().get(i));
			}
		}		
		return false;
	}
	public boolean fire(String name) {
		NPC person = null;
		/*
		  	find the npc in allNPC
		 */
		for(int i=0; i<game.getTeam().size(); i++)
		{
			if(game.getTeam().get(i).getName().equals(name))
			{
				person = game.getTeam().get(i);
			}
		}		
		return game.fire(person);
	}
	public boolean rest(String name) {
		/*
		  	find the npc in allNPC
		 */
		for(int i=0; i<game.getTeam().size(); i++)
		{
			if(game.getTeam().get(i).getName().equals(name))
			{
				return game.giveBreak(game.getTeam().get(i));
			}
		}
		return false; 
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
		
		for (NPC npc : game.getTeam()){
			npc.displayStats();
		}
		System.out.println("\nThese members are on break at the momement");
		for (NPC npc : game.getSick()){
			npc.displayStats();
		}
	}
	public void displayTime() {
		/*
			Display the current time/day
			use game.getTime();
		 */
		System.out.println("DAY " + game.getTime() );
	}
	public void displayDeadLine(){
		/*
			Display the time remaining to complete the project
		*/
		int daysPast = game.getTime();
		int totalTime = game.getDeadLine();
		System.out.println("Days Remaining: " + (totalTime-daysPast) + " days");
	}
	public void displayProgress() {
		/*
	 		print out the progress
	 		use game.getProgress();
		 */
		System.out.println("Total Progress: " + game.getProgress()/game.getTotalProgress() * 100 + "%");
	}
	public void displayHire() {
		/*
		 	print out a list of the candidates to be hired
		 	use game.getHire();
		 */
		for (NPC n : game.getHire()){
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
		System.out.println("1: Throw a party for the whole team ($1k).");
		System.out.println("2: Promote someone in the team ($15k).");
		System.out.println("3: Buy a new Espresso machine for the office ($25k).");
	
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
		switch(selection)
		{
		case 1: 	if(game.budget<1000) {
					return false;
				}
				game.triggerEvent("2+***");
				game.deacreaseBudget(1000);
				return true;
		case 2: 	if(game.budget<1000) {
					return false;
				}		
				game.triggerEvent("1*+**");
				game.deacreaseBudget(15000);
				return true;
		case 3: 	if(game.budget<1000) {
					return false;
				}
				game.triggerEvent("2+*+*");
				game.deacreaseBudget(25000);
				return true;
		}
		return false;
	}
	public boolean running() {
		/*
		  checks if the game is running
		  change active when you finish the game or quit etc..
		 */
		if (game.getBudget() <= 0){
			//lose game when you run out of money
			active = false;
		}
		else if (game.getDeadLine() < game.getTime()){
			//lose game when you run out of time
			active = false;
		}
		else if (game.getTotalProgress() <= game.getProgress()){
			//win game when the project is completed
			active = false;
		}
		return active;
	}
	public void update() {
		/*
		 	updates stuff also environment does half of it
		 	just trigger events and whatever that is left
		 	check if the game is complete
		 	use game.getProgress to get a value that decrease over time and use that to determine when the game is complete
		 */
		int temp = (int) (Math.random()*events.size());
		String s = events.get(temp).substring(0, 5);
		int percentage = Integer.parseInt(events.get(temp).substring(6, 8));
		String message = events.get(temp).substring(9);
		
		int probability = (int)(Math.random()*100)+1;
		temp = (int)(Math.random()*game.team.size());
		
		if(probability>=percentage)
		{
			if(s.charAt(0) == '1')
			{
				System.out.println(game.team.get(temp).name+""+message);
				game.triggerEvent(s);
			}
			else
			{
				System.out.println(message);
				game.triggerEvent(s);
			}
		}
		else
			System.out.println("No Event!");
		if(!running())
			System.out.println("Game Over.");

		
		//This updates time, list of hire, everyone that is on the team and sick, budget, and progress
		game.update();	
	}	
}
