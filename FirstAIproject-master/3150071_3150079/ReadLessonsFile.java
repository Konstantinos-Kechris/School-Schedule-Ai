//Kexris Kwnstantinos 3150071
//Nikos Koulos 3150079

import java.io.File;
import java.util.Scanner;
import java.util.*;

public class ReadLessonsFile {
	
	int code;
	String name;
	String classroom;
	int class1;
	int class2;
	int class3;
	Lesson lesson;
	
	public ArrayList<Lesson> l = new ArrayList<Lesson>();
	
	public ArrayList<Lesson> read() {
		
        try {

            Scanner input = new Scanner(System.in);

            File file = new File("Lessons.txt");

            input = new Scanner(file);


            while (input.hasNextLine()) {
				
				for(int i = 0; i < 6; i++) {
				
					String line = input.nextLine();
					
					if(i == 0) {
					
						code = Integer.parseInt(line);
					
					} else if (i == 1) {
					
						name = line;
					
					} else if (i == 2) {
					
						classroom = line;
							
					} else if (i == 3) {
					
						class1 = Integer.parseInt(line);
					
					} else if(i == 4) {
					
						class2 = Integer.parseInt(line);
					
					} else {
					
						class3 = Integer.parseInt(line);
					
					}
					
				}
				
				lesson = new Lesson(code,name,classroom,class1,class2,class3);
				l.add(lesson);
                
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		return l;
    }

}