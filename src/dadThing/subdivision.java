package dadThing;

public class subdivision {

	private double principleBalance = 0;	
	private double weeklyAddition = 0;
	private String name = "";
	
	
	public subdivision(double principleBalance, double weeklyAddition, String name)
	{
		this.principleBalance = principleBalance;
		this.weeklyAddition = weeklyAddition;
		this.name = name;
	}
	
	
	
	
	//mutators / accessors
	public void setPrincipleBalance(double newBalance)
	{
		this.principleBalance = newBalance;
	}
	
	public double getPrincipleBalance()
	{
		return Math.round(this.principleBalance * 100.0) / 100.0;
	}
	
	public void setWeeklyAddition(double newWeeklyAddition)
	{
		this.weeklyAddition = newWeeklyAddition;
	}
	
	public double getWeeklyAddition()
	{
		return Math.round(this.weeklyAddition * 100.0) / 100.0;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	
}
