//NPC class
public class NPC
{
    String name; //Name of NPC
    private int enthusiasm; //Productivity level (1-6)
    private int level; //Experience level (1-9)
    private int health; //Health level (1-100) 
    private Boolean leave; //Candidate for taking days off
    private double salary; //Current salary of the employee
    
    //Getter function for Name
    public String getName() {
        return name;
    }

    //Setter function for Name
    public void setName(String name) {
        this.name = name;
    }
    
    //Getter function for Enthusiasm
    public int getEnthusiasm() {
        return enthusiasm;
    }

    //Setter function for Enthusiasm
    public void setEnthusiasm(int enthusiasm) {
        this.enthusiasm = enthusiasm;
    }

    //Getter function for Level
    public int getLevel() {
        return level;
    }

    //Setter function for Level
    public void setLevel(int level) {
        this.level = level;
    }

    //Getter function for health
    public int getHealth() {
        return health;
    }

    //Setter function for health
    public void setHealth(int health) {
        this.health = health;
    }

    //Getter function for Leave
    public Boolean getLeave() {
        return leave;
    }
    
    //Setter function for Leave
    public void setLeave(Boolean leave) {
        this.leave = leave;
    }

    //Getter function for salary
    public double getSalary() {
        return salary;
    }

    //Setter function for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Displays the statistics of the NPC
    public void displayStats(){
    System.out.println("\nName:"+this.name+"\nLevel:"+this.level+"\nEnthusiasm"+this.enthusiasm+"\Health"+this.health+"\Salary"+this.salary);
    }
    

}
