package co.edu.uptc.model;

public class Activity extends Service{
	private String nameActivity;
	
	public Activity(double cost, String place, String nameActivity) {
		super(cost, place, "activity");
		this.nameActivity = nameActivity;
	}

	public String getNameActivity() {
		return nameActivity;
	}

	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}
	
}
