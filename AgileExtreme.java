import java.util.*;
public class AgileExtreme {

    public static void main(String[] args){

    		AIEnvironment game = new AIEnvironment();
    		Scanner scanner = new Scanner(System.in);
    		String input;
    		String command = "";
    		boolean boost = false;
    		int days = 0;
    		startMessage();
    		System.out.println("\nUse the command \"Help\" to get all the commands.");
    		while(true) {
    			System.out.println("\nWhat would you like to do today?");
    			input = scanner.next();
    			switch(input) {
    				case "quit":		
    					System.exit(0);
    					break;
    								
    				case "hire":		
    					while(true) {
    						System.out.println("\nHere is a list of possible candidates!");
    						//game.RecruitmentList();
    						System.out.println("Which npc would you like to hire? (Name of NPC)");
    						command = scanner.next();
    						if(command.equals("steve")/*game.hire(command)*/) {
    							System.out.println("\nCongratulations you have hired" + command);
    							break;
    						}else if(command.equals("quit")){
    							command = "";
    							break;
    						}else{
    							System.out.println("\nThe person you tried to hire does not exist.");
    						}
    					}
    					command = "";
    					break;
    								
    				case "fire":		
    					while(true) {
    						System.out.println("\nHere is a list of the current members of the development team");
    						//Game.showTeam();
    						System.out.println("Which npc would you like to fire? (Name of NPC)");
    						command = scanner.next();
    						if(command.equals("john")/*game.fire(command)*/) {
    							System.out.println(command + "\nHas been removed from the team.");
    							break;
    						}else if(command.equals("quit")){
    							command = "";
    							break;
    						}else{
    							System.out.println("\nThe person you tried to fire is not on the team.");
    						}
    					}
    					command = "";
    					break;
    				case "stats":	
    					System.out.println("\nHere are the stats of the members of the development team!");
    					//Game.displayTeam();
    					break;
    				case "rest":			
    					while(true) {
    						System.out.println("\nWhich NPC would you like to give a break to? (Name of NPC)");
    						command = scanner.next();
						if(command.equals("zack")/*game.rest(command)*/) {
							System.out.println("\n" + command + " will be off for the next few days.");
							break;
						}else if(command.equals("quit")){
							command = "";
							break;
						}else{
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
    						if(command.equals("yes")) {
    							System.out.println("\nHere are a few options that may motivate the team!");
    							//game.displayBoost
    							System.out.println("Please pick one.");		
    							switch(scanner.nextInt()) {
    								case 1:
    									/*
    									if(game.boost(1)){
    										System.out.println("You team feels slightly more motivated.");
    										boost = true;
    									}else{
    										System.out.println("You do not have enough money to do this.");
    									}
    									*/
    									boost = true;
    									break;
    								case 2:
    									/*
    									if(game.boost(2)){
    										System.out.println("You team feels slightly more motivated.");
    										boost = true;
    									}else{
    										System.out.println("You do not have enough money to do this.");
    									}
    									*/
    									boost = true;
    									break;
    								case 3:
    									/*
    									if(game.boost(3)){
    										System.out.println("You team feels slightly more motivated.");
    										boost = true;
    									}else{
    										System.out.println("You do not have enough money to do this.");
    									}
    									*/
    									boost = true;
    									break;
    								default:
    									System.out.println("\nThat is not a possible option");
    									continue;
    							}
    							break;
    						}else if(command.equals("quit") || command.equals("no")){
    							command = "";
    							break;
    						}else{
    							System.out.println("\nThat NPC does not exist");
    						}
    					}
    					//game.boost();
    					break;
    				case "buget":	
    					System.out.println("\nYour current buget is a small loan of a million");
    					//game.displayBuget();
    					break;
    				case "progress":
    					System.out.println("\nThe current progress is zero!");
    					//game.displayProgress();
    					break;
    				case "next":	
    					if( (days % 7 == 3 ) && boost) {
    						System.out.println("\nYou can get another boost this week!");
    						boost = false;
    					}
    					System.out.println("\nBoost is available again!");
    					//game.update();
    					days++;
    					break;
    				case"skip":
    					if(boost) {
    						System.out.println("\nBoost is available again!");
    						boost = false;
    					}
    					System.out.println("\nProceeding to the next day!");
    					/*
    					for(int x = 0; x < 7; x ++){
    						game.update();
    					}
    					*/
    					days += 7;
    					break;
    				case "help":
    					displayOptions();
    					break;
    				case "time":
    					System.out.println("\nThe current day is " + days + "." );
    					break;
    				default:
    					System.out.println("\nThat command does not exist");
    					break;

    			
    			}
    		}
    		/*
    		while(game.running()){
    			
    		}
    		*/
    }
    private static void startMessage() {
    		System.out.println("Welcome to Agile Extreme!");
    		System.out.println("This is a simple game where you manage a development team.");
    		System.out.println("You direct your team through a series of commands to finish a project.");
    		System.out.println("Your goal is to finish in the least amount of days possible.");
    		System.out.println("Good luck!\n\n\n\n\n");
    	
    }
    private static void displayOptions() {
    		System.out.println("\nHere is a list of all the possible commands.");
    		System.out.println("help: Displays all the possible commands");
    		System.out.println("buget: Displays the current buget");
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
