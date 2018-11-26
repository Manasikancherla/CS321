import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class AINPC extends NPC{
    ArrayList<NPC> npc = new ArrayList<NPC>();
    
    /**
     * Constructor for AINPC
     * This generates a set amount of randomized NPCs
     * The STATS of each NPC will be randomized along with a list of random names
     * @throws FileNotFoundException
     */
    public AINPC() throws FileNotFoundException{
    		Scanner scanner = new Scanner(new File("names.txt"));
        while(scanner.hasNext()){
        npc.add( createNPC(scanner.next() ) );
        }
        scanner.close();
    }
    /**
     * Generates a NPC with a given name and random STATs and returns it
     * @param name the name that will be given to the NPC
     * @return returns a generated NPC object
     */
    private NPC createNPC(String name){
    		NPC human = new NPC();
        int level = (int) (Math.random() * 5 + 2);
        human.setName(name);
        human.setLevel(level);
        human.setHealth(100);
        human.setLeave(false);
        human.setSalary((20000 * level ));
        return human;
    }
    /**
     * Pulls out a random NPC and removes it from the lists
     * @return returns a NPC object
     */
    public ArrayList<NPC> getNPC() {
        return npc;
    }
    /**
     * A number that will affect the development speed of the game
     * @param human takes in a human NPC and calculates a number with its current STATs
     * @return returns a double, the magic number
     */
    private double getMagic(NPC human){      
        return ( ( (100) * ( (35 + human.getLevel() ) + (5 * human.getEnthusiasm() ) ) ) /
                    ( human.getHealth() - ( human.getLeave() ? 4.0 : 0.0 ) ) );
    }  
    /**
     * Gets the total contribution of the team
     * @param team
     * @return double value of total contribution
     */
    public double getContribution(ArrayList<NPC> team){
        double contribution = 0.0;
        for(NPC member : team)
        {
            contribution += getMagic(member);
        }
        return contribution;
    }
    /**
     * Increases the enthusiasm of the selected NPC
     * @param human NPC object
     */
    public void increaseEnthusiasm(NPC human) {
    		human.setEnthusiasm(human.getEnthusiasm() == 6 ? human.getEnthusiasm() : human.getEnthusiasm() - 1);
    }
    /**
     * Decreases the enthusiasm of the selected NPC
     * @param human NPC object
     */
    public void decreaseEnthusiasm(NPC human) {
    		human.setEnthusiasm(human.getEnthusiasm() - 1);
    }
    /**
     * Single NPC decreases health
     * @param person
     */
    public void decayHealth(NPC person) {
		person.setHealth(person.getHealth() < 10 ? 0 : person.getHealth() - ((int) (Math.random() * 9 + 1) ) );
    }
    /**
     * Decreases the health of everyone on the team
     * If a NPC is below a certain health the leave flag will trigger
     * @param team takes in the development team
     */
    public void decayHealth(ArrayList<NPC> team) {
    		for(NPC human: team) {
    			human.setHealth(human.getHealth() - ((int)(Math.random()*2 + 1)));
    				human.setLeave(human.getHealth() <= 40 ? true : false);	
    		}
    }
    /**
     * Single NPC recovers health
     * @param person
     */
    public void recoverHealth(NPC person) {
		person.setHealth(person.getHealth() > 90 ? 100 : person.getHealth() + ((int) (Math.random() * 9 + 1) ) );
    }
    /**
     * Increases the health of everyone on the team
     * If a NPC is above a certain health the leave flag will trigger
     * @param team takes in the development team
     */
    public void recoverHealth(ArrayList<NPC> team) {
		for(NPC human: team) {
			human.setHealth(human.getHealth() - ((int)(Math.random()*3 + 8)));
				human.setLeave(human.getHealth() >= 80 ? false : true);	
		}
    }
    /**
     * Levels up the selected NPC
     * @param human NPC object
     */
    public void levelUp(NPC human){
        human.setLevel(human.getLevel() + 1);
    }
    /**
     * Levels down the selected NPC
     * @param human NPC object
     */
    public void levelDown(NPC human){
        human.setLevel(human.getLevel() - 1);
    }
    /**
     * Increases the salary of the selected NPC
     * @param human NPC object
     */
    public void increaseSalary(NPC human){
        human.setSalary(human.getSalary() + ( (int) ( (Math.random() * 9 + 1) * 1000 ) ) );
    }
    /**
     * decreases the salary of the selected NPC
     * @param human NPC object
     */
    public void decreaseSalary(NPC human){
    		human.setSalary(human.getSalary() - ( (int) ( (Math.random() * 9 + 1) * 1000 ) ) );
    }
    /**
     * Gets the total Salary 
     * @param team
     * @return double salary
     */
    public double getTotalSalary(ArrayList<NPC> team) {
    		double salary = 0;
    	        for(NPC member : team)
    	        {
    	            salary += (member.getSalary() / 26);
    	        }
    	    return salary;
    	}
    /**
     * Evaluates an event and changes the STATs of the team members
     * @param team Takes in the development team
     * @param event the event is in the format of a string
     * @return
     */
    public void evaluateEvent(ArrayList<NPC> team, String event) {       
    		switch(event.charAt(0)){
            case '0': 
            		break;
            case '1':
            		int member = (int)( Math.random()*team.size() );
               	switch(event.charAt(1))
               	{
               		case'-':decreaseEnthusiasm(team.get(member));
			    			break;
               		case'+':increaseEnthusiasm(team.get(member));
                        	break;	
               	}
               	switch(event.charAt(2))
               	{
               		case '+':levelUp(team.get(member));
               			break;
               		case '-':levelDown(team.get(member));
               			break;
               	}
              
               	switch(event.charAt(3))
               	{
               		case '+':recoverHealth(team.get(member));
               			break;
               		case '-':decayHealth(team.get(member));
               			break;
               	}
               	switch(event.charAt(4))
               	{
               		case '+':increaseSalary(team.get(member));
               			break;			
               		case '-':decreaseSalary(team.get(member));
               			break;
               	}
               	break;
            	case '2':
                	for(NPC mem: team){
                		switch(event.charAt(1))
                		{
                        	case'-':decreaseEnthusiasm(mem);
			    				break;
                        	case'+':increaseEnthusiasm(mem);
                        		break;	
               		}
                		switch(event.charAt(2)){
                			case '+':levelUp(mem);
                				break;
                			case '-':levelDown(mem);
                				break;
                		}
                		switch(event.charAt(3)){
                			case '+':recoverHealth(mem);
                				break;
                			case '-':decayHealth(mem);
                				break;
                		}
                		switch(event.charAt(4)){
                			case '+':increaseSalary(mem);
                				break;			
                			case '-':decreaseSalary(mem);
                				break;
                		}
                	}
                	break;
        	}
    	}
}
