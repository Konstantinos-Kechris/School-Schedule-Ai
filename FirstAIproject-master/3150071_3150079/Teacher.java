//Kexris Kwnstantinos 3150071
//Nikos Koulos 3150079

public class Teacher {

	private int Code;
	private String Name;
	private int CodeLesson;
	private int MaxHoursPerDay;
	private int MaxHoursPerWeek;
	
	public Teacher(int Code,String Name,int CodeLesson,int MaxHoursPerDay,int MaxHoursPerWeek) {
	
		this.Code = Code;
		this.Name = Name;
		this.CodeLesson = CodeLesson;
		this.MaxHoursPerDay = MaxHoursPerDay;
		this.MaxHoursPerWeek = MaxHoursPerWeek;
	
	}
	
	public void setMaxHoursPerDay(int h) {
	
		MaxHoursPerDay = h;
	
	}
	
	public void setMaxHoursPerWeek(int h) {
	
		MaxHoursPerWeek = h;
	
	}
	
	public int getCode() {
	
		return Code;
	
	}
	
	public String getName() {
	
		return Name;
	
	}

	public int getCodeLesson() {
	
		return CodeLesson;
	
	}
	
	public int getMaxHoursPerDay() {
	
		return MaxHoursPerDay;
	
	}
	
	public int getMaxHoursPerWeek() {
	
		return MaxHoursPerWeek;
	
	}
	
	public void printTeacher() {
	
		System.out.println("Code: " + getCode() + " \n" + "Name: " + getName() + "\n" + "CodeLeeson: " + getCodeLesson() + "\n" + "MaxHoursPerDay: " + getMaxHoursPerDay() + "\n" +
								"MaxHoursPerWeek: "	+ getMaxHoursPerWeek() + "\n");
	}
	
}