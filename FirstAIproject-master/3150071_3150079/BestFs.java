//Kexris Kwnstantinos 3150071
//Nikos Koulos 3150079

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class BestFs {

	public static void main(String [] args) {
	
		ReadTeachersFile r1 = new ReadTeachersFile();
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		teachers = r1.read();
		Teacher t;
		
		ReadLessonsFile r2 = new ReadLessonsFile();
		ArrayList<Lesson> l1 = new ArrayList<Lesson>();
		l1 = r2.read();
		Lesson l;
		
		int [] [] a = new int [7][45];
		
		for (int i = 0; i < 7; i++) {
		
			for (int j = 0; j < 45; j++) {
			
				a[i][j] = 0;
			
			}
			
		}
		
		State InitialState = new State(a,0,0);
		State CurrentState = null;
		State TerminalState = null;
		State st = null;
		InitialState.schedule[0][0] = InitialState.generateLesson(0,0);
		InitialState.setTeachers(teachers);
		InitialState.setLessons(l1);
		
		ArrayList<State> StateList = new ArrayList<State>();
		StateList.add(InitialState);
		State tempState = null;
		
		while(StateList.size() > 0) {
		
			CurrentState = StateList.get(0);
			
			if(CurrentState.isTerminal()) {
			
				CurrentState.WriteResult();
				break;
			
			}
		
			StateList.addAll(CurrentState.getChildren());
			
			for (int i = 0; i < StateList.size(); i++) {
				
				tempState = StateList.remove(i);
				tempState.calculate();
				StateList.add(i,tempState);

			}
		
			Collections.sort(StateList,new Comparator<State>() {
		
				public int compare(State s1, State s2) {
			
					return Integer.valueOf(s1.score).compareTo(s2.score);
			
				}
		
			});
		
		
		
		}

	}

}