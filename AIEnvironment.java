import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AIEnvironment {

	private double budget = 0;
	private int days = 0;
	private double goal = 0;

	public EnviAi()
	{
		this.days = 0;
		this.budget = 0;
		this.goal = 0;
	}

	public boolean hireEmployee()
	{
		boolean hired = false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Are you sure you want to hire Xyz? (y/n)");
		char input = keyboard.next().charAt(0);
		if(input == 'y')
		{
			// add method from Enviroment class
			System.out.println("Xyz was hired");
			hired = true;
		}
		else if(input == 'n')
			System.out.println("Xyz was not hired");
		
		else
			System.out.println("Wrong input");
		return hired;
	}
	
	public boolean fireEmployee()
	{
		boolean fired = false;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Are you sure you want to fire Xyz? (y/n)");
		char input = keyboard.next().charAt(0);
		if(input == 'y')
		{
			// remove method from Enviroment class
			System.out.println("Xyz was fired");
			fired = true;
		}
		else if(input == 'n')
			System.out.println("Xyz was not fired");
		
		else
			System.out.println("Wrong input");
		return fired;
	}
	
	public boolean createProject()
	{
		boolean created = false;
		// avg income of developers per year 105k
		budget = (105000/365) * 9;  // avg divided by days in a year and multiply by max # of devs
		
		days = (int)(Math.random()*180)+1;
		days = 7;   // FOR TESTING PURPOSES ONLY
		// final budget + extra
		budget = (budget*days) + (50*days);
		
		// 4 avg productivity * 9 max # devs * # of days
		goal = 4*9*days;
		created = true;
		return created;
	}
	
	public String createEvent() throws FileNotFoundException
	{
		Scanner events = new Scanner(new File("events.txt"));
		String result;
		int percentage;
		int probability;
		String message;
		while(events.hasNext())
		{
			result = events.next();
			percentage = Integer.parseInt(events.next());
			message = events.nextLine();
			probability = (int) (Math.random()*100)+1;
			if(probability<=percentage)
			{
				// pick npc?
				System.out.println(message);
 				System.out.println(result);  // test purpose only
				return result;
			}
		}
		
		return "1****";
	}
	public void update(int d, double b, double g)
	{
		this.days -= d;
		this.budget -= b;
		this.goal -= g;
	}
	public void setDays(int newDays)
	{
		this.days = newDays;
	}
	
	public void setBudget(double newBudget)
	{
		this.budget = newBudget;
	}
	
	public void setGoal(double newGoal)
	{
		this.goal = newGoal;
	}
	
	public int getDays()
	{
		return this.days;
	}
	
	public double getBudget()
	{
		return this.budget;
	}
	
	public double getGoal()
	{
		return this.goal;
	}
}
