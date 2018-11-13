import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class AINPC extends NPC{
    ArrayList<NPC> npc = new ArrayList<NPC>();
    /**
     * Constructor for NPCAI
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
        int level = (int) (Math.random() * 5 +3);
        human.setName(name);
        human.setLevel(level);
        human.setHealth(100);
        human.setLeave(false);
        human.setSalary((20000 * level ) / 12.0);
        return human;
    }
    /**
     * Pulls out a random NPC and removes it from the lists
     * @return returns a NPC object
     */
    public NPC getNPC() {
        return npc.remove( ( (int) Math.random() * npc.size() ) );
    }
    /**
     * A number that will affect the development speed of the game
     * @param human takes in a human NPC and calculates a number with its current STATs
     * @return returns a double, the magic number
     */
    public double getMagic(NPC human){

        return ( ( (100) * ( (35 + human.getLevel() ) + (5 * human.getEnthusiasm() ) ) ) /
                    ( human.getHealth() - ( human.getLeave() ? 4.0 : 0.0 ) ) );
    }
    /**
     * Increases the enthusiasm of the selected NPC
     * @param human NPC object
     */
    public void increaseEnthusiasm(NPC human) {
    		human.setEnthusiasm(human.getEnthusiasm() ==6 ? human.getEnthusiasm() : human.getEnthusiasm() - 1);
    }
    /**
     * Decreases the enthusiasm of the selected NPC
     * @param human NPC object
     */
    public void decreaseEnthusiasm(NPC human) {
    		human.setEnthusiasm(human.getEnthusiasm() - 1);
    }
    /**
     * Decreases the health of everyone on the team
     * If a NPC is below a certain health the leave flag will trigger
     * @param team takes in the development team
     */
    public void decayHealth(ArrayList<NPC> team) {
    		for(NPC human: team) {
    			human.setHealth(human.getHealth() - 1);
    				human.setLeave(human.getHealth() <= 55 ? true : false);	
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
    public void leveldown(NPC human){
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
    		human.setSalary(human.getSalary() + ( (int) ( (Math.random() * 9 + 1) * 1000 ) ) );
    }
    /**
     * Evaluates an event and changes the STATs of the team members
     * @param team Takes in the development team
     * @param event the event is in the format of a string
     * @return
     */
    public ArrayList<NPC> evaluateEvent(ArrayList<NPC> team, String event) {		
    	int member = (int)Math.random()*team.size();
        NPC dummy = (NPC)team.get(member).clone();
        
        if(event.charAt(0) == '+'&&team.get(member))
            dummy.setEnthusiasm(dummy.getEnthusiasm()+1);
        else if(event.charAt(0) == '-')
            dummy.setEnthusiasm(dummy.getEnthusiasm()-1);
        
        if(event.charAt(1) == '-')
        {
            if(dummy.getHealth>39)
                dummy.setHealth((int)dummy.getHealth()*0.75);
            else
                dummy.setHealth(30);
                printf(dummy.getName()+" is in critical condition. Needs to be fired immediately.\n");
        }
            
        team.get(member) = (NPC)dummy.clone();
        return team;
    }
}
