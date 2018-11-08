import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class AINPC extends NPC{
    ArrayList<String> names = new ArrayList<String>();
    public AINPC() throws FileNotFoundException{
    Scanner scanner = new Scanner(new File("names.txt"));
        while(scanner.hasNext()){
        names.add(scanner.next());
        }
    }
    private NPC createNPC(){
        NPC human = new NPC();
        return human;
    }
    private NPC baseStats(NPC human){
    	
        int level = (int) (Math.random() * 5 +3);
        human.setName(names.remove((int)(Math.random() * names.size())));
        human.setLevel(level);
        human.setHealth(100);
        human.setLeave(false);
        human.setSalary((20000 * level ) / 12.0);
        return human;
    }
    public double getMagic(NPC human){

        return ( ( (100) * ( (35 + human.getLevel() ) + (5 * human.getEnthusiasm() ) ) ) /
                    ( human.getHealth() - ( human.getLeave() ? 4.0 : 0.0 ) ) );
        }
    private void changeSalary(double change, NPC human){
        human.setSalary(human.getSalary() + change);
        human.setEnthusiasm(change >= 0 ?
        (human.getEnthusiasm() != 6 ? human.getEnthusiasm() + 1 : human.getEnthusiasm()) : human.getEnthusiasm() -1);
    }
    private void levelup(NPC human){
        human.setLevel(human.getLevel() + 1);
        human.setHealth(100);
        human.setEnthusiasm(human.getEnthusiasm() != 6 ? human.getEnthusiasm() + 1 : human.getEnthusiasm());
    }
   
}

