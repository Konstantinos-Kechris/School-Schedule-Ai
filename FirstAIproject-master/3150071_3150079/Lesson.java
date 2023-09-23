//Kexris Kwnstantinos 3150071
//Nikos Koulos 3150079

public class Lesson {

	private int Code;
	private String Name;
	private String Classroom;
	private int hoursForFirst;
	private int hoursForSecond;
	private int hoursForThird;
	
	public Lesson(int Code,String Name,String Classroom,int hoursForFirst,int hoursForSecond, int hoursForThird) {
		
		this.Code = Code;
		this.Name = Name;
		this.Classroom = Classroom;
		this.hoursForFirst = hoursForFirst;
		this.hoursForSecond = hoursForSecond;
		this.hoursForThird = hoursForThird;
		
	}
	
	public void sethoursForFirst(int h) {
	
		hoursForFirst = h;
	
	}
	
	public void sethoursForSecond(int h) {
	
		hoursForSecond = h;
	
	}
	
	public void sethoursForThird(int h) {
	
		hoursForThird = h;
	
	}
	
	public int getCode() {
	
		return Code;
	
	}
	
	public String getName() {
	
		return Name;
	
	}
	
	public String getClassroom() {
	
		return Classroom;
	
	}
	
	public int gethoursForFirst() {
	
		return hoursForFirst;
	
	}
	
	public int gethoursForSecond() {
	
		return hoursForSecond;
	
	}
	
	public int gethoursForThird() {
	
		return hoursForThird;
	
	}
	
	public void printLesson() {
	
		System.out.println("Code: " + getCode() + " \n" + "Name: " + getName() + "\n" + "Classroom: " + getClassroom() + "\n" + "HoursForFirst: " + gethoursForFirst() + "\n" +
								"hoursForSecond: "	+ gethoursForSecond() + "\n" + "HoursForThird: " + gethoursForThird() + "\n");
	}

}