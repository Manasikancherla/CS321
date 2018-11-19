import java.lang.*;

public class Environment {

public String[] events;
public NPC[] current_employ;
public int daysPast = 0;
public int timeFrame;
public int budget;
public double progress = 0.0;

public void createEvent(){
  Scanner s = new Scanner(System.in);
  System.out.println("DAY " + daysPast);
  System.out.println("It's a new day at the office! You sit down at your desk and check your email. Here's what' going on around the office today:");
  System.out.println("");
  //event call
  System.out.println("");
  displayProgress();
  //display player commmands (e.g. Hire, Fire, Next Day)
  System.out.println("");
  System.out.println("H = Hire       F = Fire      T = Advance Day");
  if(s.next() == "h" || "H"){
    //Hire
  }
  else if(s.next() == "f" || "F"){
    //Fire
  }
  else if(s.next() == "t" || "T"){
    nextDay();
  }
  else {
  }
}

public void trackDaysPast(){
  if (daysPast > timeFrame){
    //lose game
    System.out.println("You get a call from the manager. He's very upset! Seems like you've gone over time. He says he's assigning somone new that will manage things properly. Better pack up your things! [GAME OVER]");
  }
}

public void displayProgess(){
  System.out.println("Total Progress: " + progress);
}
  
public void setCurrentEmploy(NPC[] employees){
  current_employ = employees;
}
  
public void nextDay(){
  daysPast++;
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
  createEvent();
}
  
public void setTimeFrame(int newTimeFrame){
  timeFrame = newTimeFrame; //40*(int)(35*Math.random()+1);
}
  
public void setBudget(int newBudget){
  budget = newBudget;
}

public void setProgress(double newProgress){
  progress += (newProgress/100);
}

}
