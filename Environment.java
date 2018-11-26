import java.io.FileNotFoundException;
import java.util.*;

public class Environment {
	
	ArrayList<NPC> team = new ArrayList<NPC>();
	ArrayList<NPC> sick = new ArrayList<NPC>();
	ArrayList<NPC> hire = new ArrayList<NPC>();
	ArrayList<NPC> population;
	AINPC people;
	
	double budget;
	double progress;
	double totalProgress;
	int time;
	int timeframe;
	
	/**
	 * Constructor for environment
	 * @throws FileNotFoundException
	 */
	public Environment() throws FileNotFoundException {
		people = new AINPC();
		population = people.getNPC();
		//Small Loan of a million
		budget = 1000000; 
		totalProgress = 100;
		progress = 0;
		time = 1;
	}
	/**
	 * Getter for the team
	 * @return ArrayList<NPC)
	 */
	public ArrayList<NPC> getTeam() {
		return team;
	}
	/**
	 * Getter for the team
	 * @return ArrayList<NPC)
	 */
	public ArrayList<NPC> getHire(){
		return hire;
	}
	/**
	 * Getter for the sick
	 * @return ArrayList<NPC)
	 */
	public ArrayList<NPC> getSick(){
		return sick;
	}
	/**
	 * Getter for the population
	 * @return ArrayList<NPC)
	 */
	public ArrayList<NPC> getPopulation(){
		return population;
	}
	/**
	 * Getter for budget
	 * @return double
	 */
	public double getBudget() {
		return budget;
	}
	/**
	 * Getter for days
	 * @return integer
	 */
	public int getTime() {
		return time;
	}
	/**
	 * Getter for total to complete the project
	 * @return integer
	 */
	public int getTimeframe() {
		return timeframe;
	}
	/**
	 * Getter for progress
	 * @return double
	 */
	public double getProgress() {
		return progress;
	}
	/**
	 * Getter for total progress to complete the project
	 * @return double
	 */
	public double getTotalProgress() {
		return totalProgress;
	}
	/**
	 * Hires the NPC
	 * @param person
	 * @return
	 */
	public boolean hire(NPC person) {
		
		return team.add(population.remove(population.indexOf(person)));
	}
	/**
	 * Fires the NPC
	 * @param person
	 * @return
	 */
	public boolean fire(NPC person) {
		
		return population.add(team.remove(team.indexOf(person)));
	}
	/**
	 * Checks who is sick on the team
	 */
	public void checkSick() {
		//Checks if anyone is sick
		for(NPC person : team)
		{
			if(person.getLeave()) {
				sick.add(person);
				team.remove(person);
			}
		}		
	}
	/**
	 * Checks who has recovered from the group of sick 
	 */
	public void checkRecover() {
		//Checks if anyone has recovered
		for(NPC person : sick)
		{
			if(person.getLeave() != true) {
				team.add(person);
				sick.remove(person);
			}
		}	
	}
	/**
	 * Sends a person to the sick group
	 * @param person
	 */
	public boolean giveBreak(NPC person) {
		return sick.add(team.remove(team.indexOf(person)));
	}
	/**
	 * Decrease the budget
	 * @param value
	 */
	public void deacreaseBudget(double value) {
		budget -= value;
	}
	/** 
	 * Adds people to the list of candidates to be hired
	 */
	public void newHire() {
		for(int x = 0; x < 3; x++) {
			//People in the front of the list is removed
			population.add(hire.remove(0));
			//People are added to the end of the list and they do have a tiny chance of reappearing for hire
			hire.add(population.remove( ( (int) ( Math.random()*population.size() ) ) ) );
		}	
	}
	/**
	 * Triggers an event on the team
	 * @param Event
	 */
	public void triggerEvent(String event) {
		people.evaluateEvent(team, event);
	}
	/**
	 * updates the state of the game
	 */
	public void update() {
		//Updates on the progress
		newHire();
		progress -= people.getContribution(team) / 100;
		//Decreases the budget every two weeks
		if(time % 14 == 0) {
			budget -= people.getTotalSalary(team);
			budget -= people.getTotalSalary(sick);
		}
		//Decays everyone health after a day of work
		people.decayHealth(team);
		//Removes the ones who is sick from the team
		checkSick();
		//Heals everyone
		people.RecoverHealth(sick);
		//Moves the healthy back into the team
		checkRecover();
		//Increments the day
		time++;	
	}
	
	public boolean createProject()
	{
		boolean created = false;
		// avg income of developers per year 120k
		budget = (120000/365) * 9;  // avg divided by days in a year and multiply by max # of devs
		
		time = (int)(Math.random()*180)+7;
		time = 7;   // FOR TESTING PURPOSES ONLY
		// final budget + extra
		budget = (budget*days) + (50*days);
		
		// 4 avg productivity * 9 max # devs * # of days
		totalProgress = 4*9*time;
		created = true;
		return created;
	}
}
