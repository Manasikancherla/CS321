import java.lang.*;

public class Environment {

public Arraylist<NPC> atOffice = new Arraylist<NPC>();
public Arraylist<NPC> outToday = new Arraylist<NPC>();
private Arraylist<NPC> team;
  
public boolean hire(NPC n){
  team.add(n);
  atOffice.add(n);
  return true;
}
  
public boolean fire(NPC n){
  team.remove(n);
  if (atOffice.contains(n)){
    atOffice.remove(n);
    return true;
  }
  else if (outToday.contains(n)){
    outToday.remove(n);
    return true;
  }
  else {
    return false;
  }
}
  
public leave(NPC n){
  outToday.add(atOffice.remove(n));
}
  
public returnToOffice(NPC n){
  atOffice.add(outToday.remove(n));
}
  
/*public void writeEvent(){
  Scanner s = new Scanner(System.in);
  System.out.println("DAY " + daysPast);
  System.out.println("");
  System.out.println("It's a new day at the office! You sit down at your desk and check your email. Here's what' going on around the office today:");
  System.out.println("");
  AIEnvironment.createEvent(); //event call
  System.out.println("");
  displayProgress();
  System.out.println("");
  System.out.println("H = Hire       F = Fire      T = Advance Day"); //display player commmands (e.g. Hire, Fire, Next Day)
  if(s.next() == "h" || "H"){
     AIEnvironment.hireEmployee(); //Hire
  }
  else if(s.next() == "f" || "F"){
    AIEnvironment.fireEmployee();//Fire
  }
  else if(s.next() == "t" || "T"){
    nextDay();
  }
  else {
  }
}*/

public boolean trackDaysPast(){
  if (AIEnvironment.getDaysPast() > AIEnvironment.getDays()){
    //lose game
    System.out.println("You get a call from the manager. He's very upset! Seems like you've gone over time. He says he's assigning somone new that will manage things properly. Better pack up your things! [GAME OVER]");
    return false;
  }
  else {
   return true;
  }
}

public void displayProgess(){
  System.out.println("Total Progress: " + progress);
}
  
public void nextDay(){
  AIEnvironment.update(1, 0, 0);
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  System.out.println("");
  //writeEvent();
}
  
public String displayTeam(){
  for (NPC n: team){
   System.out.print(n.getName() + " ");
   System.out.println("");
  }
}

public void setProgress(double newProgress){
  progress += (newProgress/100);
}

}
