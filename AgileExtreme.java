import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
public class AgileExtreme {

    public static void main(String[] args) throws FileNotFoundException{
    		Logger logger = java.util.logging.Logger.getLogger("Logs");
    		FileHandler file;
    		try {
				file = new FileHandler("Logs.log");
				logger.addHandler(file);
    				SimpleFormatter format = new SimpleFormatter();
    				file.setFormatter(format);
    				logger.info("Start of log");
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		AIEnvironment game = new AIEnvironment();
    		Scanner scanner = new Scanner(System.in);
    		String input;
    		String command = "";
    		boolean boost = false;
    		startMessage();
    		System.out.println("\nUse the command \"Help\" to get all the commands.");
    		while(game.running()) {
    			System.out.println("\nWhat would you like to do today?");
    			input = scanner.next();
    			logger.info("User input: " + input);
    			switch(input) {
    				case "quit":
						System.out.println("\nThanks for playing!");
    					return;
    								
    				case "hire":		
    					while(true) {
    						System.out.println("\nHere is a list of possible candidates!");
    						game.displayHire();
    						System.out.println("Which npc would you like to hire? (Name of NPC)");
    						command = scanner.next();
    						if(game.hire(command)) {
    							logger.info("Hire: " + command);
    							logger.info("Successfully hired");
    							System.out.println("\nCongratulations you have hired" + command);
    							break;
    						}else if(command.equals("quit")){
    							logger.info("Hire: " + command);
    							logger.info("Successfully quit hire");
    							command = "";
    							break;
    						}else{
    							logger.info("Hire: " + command);
    							logger.info("Failed to hire");
    							System.out.println("\nThe person you tried to hire does not exist.");
    						}
    					}
    					command = "";
    					break;
    								
    				case "fire":		
    					while(true) {
    						System.out.println("\nHere is a list of the current members of the development team");
    						game.displayTeam();
    						System.out.println("Which npc would you like to fire? (Name of NPC)");
    						command = scanner.next();
    						if(game.fire(command)) {
    							logger.info("Fire: " + command);
    							logger.info("Successfully fired");
    							System.out.println(command + "\nHas been removed from the team.");
    							break;
    						}else if(command.equals("quit")){
    							logger.info("Fire: " + command);
    							logger.info("Successfully quit fire");
    							command = "";
    							break;
    						}else{
    							logger.info("Fire: " + command);
    							logger.info("Failed to fire");
    							System.out.println("\nThe person you tried to fire is not on the team.");
    						}
    					}
    					command = "";
    					break;
    				case "stats":	
    					System.out.println("\nHere are the stats of the members of the development team!");
    					game.displayStats();
    					logger.info("Stats were displayed");
    					break;
    				case "rest":			
    					while(true) {
    						System.out.println("\nWhich NPC would you like to give a break to? (Name of NPC)");
    						game.displayTeam();
    						command = scanner.next();
						if(game.rest(command)) {
							logger.info("Rest: " + command);
							logger.info("Successfully rest");
							System.out.println("\n" + command + " will be off for the next few days.");
							break;
						}else if(command.equals("quit")){
							logger.info("Rest: " + command);
							logger.info("Successfully quit rest");
							command = "";
							break;
						}else{
							logger.info("Rest: " + command);
							logger.info("Failed to rest");
							System.out.println("\nThat NPC does not exist");
						}
					}
    						command = "";
    						break;
    				case "boost":
    					if(boost) {
						System.out.println("\nYou can only use this once a week");
						break;
					}
    					while(true) {
    						System.out.println("\nWould you like to spend some money to motivate the team?");
    						command = scanner.next();
    						logger.info("Boost Confirmation: " + command);
    						if(command.equals("yes")) {
    							System.out.println("\nHere are a few options that may motivate the team!");
    							game.showBoost();
    							System.out.println("Please pick one.");		
    							switch(scanner.nextInt()) {
    								case 1:  									
    									if(game.useBoost(1)){
    										logger.info("Boost: 1 successful");
    										boost = true;
    									}else{
    										logger.info("Boost: 1 - not enough money");
    										System.out.println("You do not have enough money to do this.");
    									}
    									boost = true;
    									break;
    								case 2:
    									if(game.useBoost(2)){
    										logger.info("Boost: 2 successful");
    										boost = true;
    									}else{
    										logger.info("Boost: 2 not enough money");
    										System.out.println("You do not have enough money to do this.");
    									}
    									boost = true;
    									break;
    								case 3:
    									if(game.useBoost(3)){
    										logger.info("Boost: 3 successful");
    										boost = true;
    									}else{
    										logger.info("Boost: 3 not enough money");
    										System.out.println("You do not have enough money to do this.");
    									}
    									break;
    								default:
    									System.out.println("\nThat is not a possible option");
    									logger.info("Boost: Invalid user input");
    									continue;
    							}
    							break;
    						}else if(command.equals("quit") || command.equals("no")){
    							logger.info("boost: " + command);
    							logger.info("Successfully quit boost");
    							command = "";
    							break;
    						}else{
    							logger.info("Rest: " + command);
    							logger.info("Failed to boost");
    							System.out.println("\nThat NPC does not exist");
    						}
    					}
    					break;
    				case "budget":	
    					System.out.println("\nYour initial budget is a small loan of a million");
    					game.displayBudget();
    					logger.info("Budget was displayed");
    					break;
				case "progress":
    					game.displayProgress();
    					logger.info("Progress was displayed");
    					break;
    				case "next":	
    					if( (game.getTime() % 7 == 3 ) && boost) {
    						System.out.println("\nYou can get another boost this week!");
    						boost = false;
    						logger.info("SYSTEM: boost is available again");
    					}
    					game.update();
    					logger.info("Proceeding to the next day");
    					break;
    				case"skip":
    					if(boost) {
    						System.out.println("\nBoost is available again!");
    						boost = false;
    						logger.info("SYSTEM: boost is available again");
    					}
    					System.out.println("\nProceeding to the next day!");
    					for(int x = 0; x < 7; x ++){
    						game.update();
    					}
    					logger.info("Proceeding to the next week");
    					break;
    				case "help":
    					displayOptions();
    					break;
    				case "time":
    					game.displayTime();
    					break;
    				default:
    					System.out.println("\nThat command does not exist");
    					break;
    			}
    		}
    		scanner.close();

    		System.exit(0);
    }
    private static void startMessage() {
    		System.out.println("Welcome to Agile Extreme!");
    		System.out.println("This is a simple game where you manage a development team.");
    		System.out.println("You direct your team through a series of commands to finish a project.");
    		System.out.println("Your goal is to finish in the least amount of days possible.");
    		System.out.println("Good luck!\n\n\n\n");
    }
    private static void displayOptions() {
    		System.out.println("\nHere is a list of all the possible commands.");
    		System.out.println("help: Displays all the possible commands");
    		System.out.println("budget: Displays the current budget");
    		System.out.println("progress: Displays the current progress");
    		System.out.println("next: Proceeds to the next day");
    		System.out.println("hire: Hire more members to the development team");
    		System.out.println("fire: Fire members from the development team");
    		System.out.println("rest: Give your employees days off");
    		System.out.println("stats: Display the stats of all employees.");
    		System.out.println("boost: Motivate your employees!");
    		System.out.println("time: Displays the current day.");
    }
}
