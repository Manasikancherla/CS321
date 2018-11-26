import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AIEnvironment{
	private double budget;
	private int days;
	private double goal;
	private int currentDays;
	private AINPC npc;
	private Environment envi;
	public AIEnvironment() throws FileNotFoundException
	{
		envi = new Environment();
		npc = new AINPC();
		this.days = 0;
		this.budget = 0;
		this.goal = 0;
		this.currentDays = 0;
	}

	public boolean hireEmployee()
	{
		boolean hired = false;
		NPC candidate;
		char input = 'n';
		Scanner keyboard = new Scanner(System.in);
		
		while(!hired)
		{
			candidate = npc.getNPC();
			System.out.println("Hello boss, there is one candidate for the job:");
			System.out.println("name:\t"+candidate.getName());
			System.out.println("salary:\t"+candidate.getSalary());
			System.out.println("level"+candidate.getLevel());
			System.out.println("Are you sure you want to hire "+candidate.getName()+"? (y/n) b:back");
			input = keyboard.next().charAt(0);
			if(input == 'y')
			{
				System.out.println("Congratulations !! "+ candidate.getName()+" was hired.");
				hired = true;
			}
			else if(input == 'n')
				System.out.println(candidate.getName()+" was not hired.");
			
			else
			{
				System.out.println("No more candidate to report boss.");
			}
		}
		keyboard.close();
		return hired;
	}
	
	public boolean fireEmployee()
	{
		boolean fired = false;
		System.out.println("Here is our team boss: ");
		envi.displayTeam();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Who do you want to fire? b: back");
		String input = keyboard.nextLine();
		if(input.equalsIgnoreCase("back"))
			return false;
		
		System.out.println("Are you sure you want to fire "+ input +"? (y/n)");
		char input2 = keyboard.next().charAt(0);
		if(input2 == 'y')
		{
			envi.fire(input);
			System.out.println(input+" was fired.");
			fired = true;
		}
		else 
			System.out.println(input+" was not fired.");
		
		return fired;
	}
	
	public boolean createProject()
	{
		boolean created = false;
		// avg income of developers per year 105k
		budget = (105000/365) * 9;  // avg divided by days in a year and multiply by max # of devs
		
		days = (int)(Math.random()*180)+7;
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
				int index = (int) (Math.random()+envi.atOffice.size()); 
				NPC employee = envi.atOffice.get(index);
				System.out.println(employee+""+message);
 				System.out.println(result);  // for testing purpose  only
				return result;
			}
		}
		
		return "0****";
	}
	public String boost()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Which one would you like to use?? (1/2/3) b: go back");
		System.out.println("1: Buy food for the whole team ($100).");
		System.out.println("2: Promote someone in the team ($15k).");
		System.out.println("3: Buy a new Espresso machine for the office ($500).");
		char input = keyboard.nextLine().charAt(0);
		switch(input)
		{
			case 1: System.out.println("The team loved the food and their productivity has increased.");
					updateBudget(100);
					return "2+***";
			case 2: System.out.println("Who do you want to promote?");
					envi.displayTeam();
					String ename = keyboard.nextLine();
					if(envi.promote(ename))
						System.out.println(ename+" was promoted.");
					else
						System.out.println(ename+" was not promoted");
					break;
			case 3: System.out.println("The team loved the Espresso machine and their productivity has increased.");
					return "2+***";
			default:System.out.println("No boost was applied.");
					break;
		}
		return "0****";
	}
	
	public void updateDays(int newDays)
	{
		this.days -= newDays;
	}
	public void updateProgress(int newGoal)
	{
		this.goal -= newGoal;
	}	public void updateBudget(int newBudget)
	{
		this.budget -= newBudget;
	}	
	public void updateCurrentDays(int newCDays)
	{
		this.currentDays += newCDays;
	}
	public void setCurrentDays(int newCDays)
	{
		this.currentDays = newCDays;
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
	public int getCurrentDays()
	{
		return this.currentDays;
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
	public static void main (String[] args) throws FileNotFoundException
	{
		EnviAi obj = new EnviAi();
		
		for(int i=1; i<=5; i++)
		{
			obj.createEvent();
		}
		
		obj.hireEmployee();
		obj.fireEmployee();
	}
}
