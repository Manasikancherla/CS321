import java.lang.*;

public class Environment {

public String[] events;
public NPC[] current_employ;
public int daysPast = 0;
public int timeFrame;
public int budget;
public double progress = 0.0;

public void createEvent(){
}

public void trackDaysPast(){
  if (daysPast > timeFrame){
    //lose game
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
