//Kexris Kwnstantinos 3150071
//Nikos Koulos 3150079

import java.io.File;
import java.util.Scanner;
import java.util.*;

public class ReadTeachersFile {
	
	int code;
	String name;
	int codeLesson;
	int MaxHoursPerDay;
	int MaxHoursPerWeek;
	
	Teacher teacher;
	
	public ArrayList<Teacher> t = new ArrayList<Teacher>();
	
	public ArrayList<Teacher> read() {
		
        try {

            Scanner input = new Scanner(System.in);

            File file = new File("Teachers.txt");

            input = new Scanner(file);


            while (input.hasNextLine()) {
				
				for(int i = 0; i < 5; i++) {
				
					String line = input.nextLine();
					
					if(i == 0) {
					
						code = Integer.parseInt(line);
					
					} else if (i == 1) {
					
						name = line;
					
					} else if (i == 2) {
					
						codeLesson = Integer.parseInt(line);
							
					} else if (i == 3) {
					
						MaxHoursPerDay = Integer.parseInt(line);
					
					} else {
					
						MaxHoursPerWeek = Integer.parseInt(line);
					
					}
					
				}
				
				teacher = new Teacher(code,name,codeLesson,MaxHoursPerDay,MaxHoursPerWeek);
				t.add(teacher);
                
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		return t;
    }

}