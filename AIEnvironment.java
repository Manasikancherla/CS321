
public class AIEnvironment {

	public void runAll()
	{
		sick();
		marriage();
		vacation();
		timeOff();
	}
	public boolean sick()
	{
		int chance = (int) (Math.random()*100)+1;
		boolean result = false;

		if(chance >0 && chance<=60)
			System.out.println("No one is sick (60%)");
		else if(chance>60 && chance<=100)
			{
			System.out.println("Someone is sick (40%)");
			result = true;
			}	
		else
			System.out.println("fked up");
		
			return result;
	}
	
	public boolean vacation()
	{
		int chance = (int) (Math.random()*100+1);
		boolean result = false;
		
		if(chance >0 && chance<=80)
			System.out.println("No one is going on vacation (80%)");
		else if(chance>80 && chance<=100)
			{
			System.out.println("Someone is going on vacation (20%)");
			result = true;
			}	
		else
			System.out.println("fked up");
		
		return result;
	}
	
	public boolean marriage()
	{
		int chance = (int) (Math.random()*100)+1;
		boolean result = false;
		
		if(chance >0 && chance<=90)
			System.out.println("No one is getting married (90%)");
		else if(chance>90 && chance<=100)
			{
			System.out.println("Someone is getting married (10%)");
			result = true;
			}	
		else
			System.out.println("fked up");
		
		return result;
	}
	
	public boolean timeOff()
	{
		int chance = (int) (Math.random()*100)+1;
		boolean result = false;
		
		if(chance >0 && chance<=70)
			System.out.println("No one has requested time off (70%)");
		else if(chance>70 && chance<=100)
			{
			System.out.println("Someone has requested time off(30%)");
			result = true;
			}	
		else
			System.out.println("fked up");
		
		return result;
	}
	
	public static void main (String[] args)
	{
		EnviAi obj = new EnviAi();
		
		for(int i=1; i<=5; i++)
		{
			System.out.println("Run number: "+i);
			obj.runAll();
			System.out.println("-------------------------------------------");
		}
	}
}
