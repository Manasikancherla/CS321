import java.lang.*;

public class Environment {

public String[] events;
public int daysPast = 0;
public int timeFrame = 40*(int)(35*Math.random()+1);
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
}

}
