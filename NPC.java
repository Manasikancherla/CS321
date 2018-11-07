//NPC class
public class NPC
{
    String name; //Name of NPC
    private int enthusiasm; //Productivity level (1-6)
    private int level; //Experience level (1-9)
    private int health; //Health level (1-100)
    private Boolean leave; //Candidate for taking days off
    private double salary; //Current salary of the employee

    public NPC(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnthusiasm() {
        return enthusiasm;
    }

    public void setEnthusiasm(int enthusiasm) {
        this.enthusiasm = enthusiasm;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Boolean getLeave() {
        return leave;
    }

    public void setLeave(Boolean leave) {
        this.leave = leave;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
