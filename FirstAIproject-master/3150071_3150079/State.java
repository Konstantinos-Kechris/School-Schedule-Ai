//Kexris Kwnstantinos 3150071
//Nikos Koulos 3150079

import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class State {
	
	protected int currentX;
	protected int currentY;
	protected int score;
	protected int [] [] schedule = new int [7][45];
	protected ArrayList<Teacher> Teachers = new ArrayList<Teacher>();
	protected ArrayList<Lesson> Lessons = new ArrayList<Lesson>();
	protected String[] data = new String [45];
	
	public State() {
		
		score = 0;
		currentX = 0;
		currentY = 0;
		for (int i = 0; i < 7; i++) {
		
			for (int j = 0; j < 45; j++) {
			
				schedule[i][j] = 0;
			
			}
			
		}
		
		int j = 0;
		
		for (int i = 0; i < 5; i++) {
			
			data[j] = "A1";
			j++;
			data[j] = "A2";
			j++;
			data[j] = "A3";
			j++;
			data[j] = "B1";
			j++;
			data[j] = "B2";
			j++;
			data[j] = "B3";
			j++;
			data[j] = "C1";
			j++;
			data[j] = "C2";
			j++;
			data[j] = "C3";
			j++;
			
		}
	
	}
	
	public State(int [] [] a,int x,int y){
	
		for (int i = 0; i < 7; i++) {
		
			for (int j = 0; j < 45; j++) {
			
				schedule[i][j] = a[i][j];
			
			}
			
		}
		score = 0;
		currentX = x;
		currentY = y;
		int j = 0;
		
		for (int i = 0; i < 5; i++) {
			
			data[j] = "A1";
			j++;
			data[j] = "A2";
			j++;
			data[j] = "A3";
			j++;
			data[j] = "B1";
			j++;
			data[j] = "B2";
			j++;
			data[j] = "B3";
			j++;
			data[j] = "C1";
			j++;
			data[j] = "C2";
			j++;
			data[j] = "C3";
			j++;
			
		}
	
	}
	
	public int getcurrentX() {
	
		return currentX;
	
	}
	
	public int getcurrentY() {
	
		return currentY;
	
	}
	
	public void setTeachers(ArrayList<Teacher> t ) {
	
		Teacher t1;
		
		for (int i = 0; i < t.size(); i++) {
		
			t1 = t.get(i);
			Teachers.add(t1);
			
		}
		
	}
	
	public void setLessons(ArrayList<Lesson> l ) {
	
		Lesson l1;
		
		for (int i = 0; i < l.size(); i++) {
		
			l1 = l.get(i);
			Lessons.add(l1);
			
		}
	
	}
	
	public boolean isTerminal() {
	
		int count = 0;
		for(int i = 0; i < 7; i++) {
		
			for (int j = 0; j < 45; j++) {
			
				if (schedule[i][j] == 0) {
				
					count++;
				
				}
			
			}
		
		}
		
		if (count != 0) {
		
			return false;
		
		}else {
		
			return true;
		
		}
	
	}
	
	public void printState() {
	
		for (int i = 0; i < 7; i++) {
		
			for (int j = 0; j < 45; j++) {
			
				System.out.print(schedule[i][j] + " ");
				
			}
			
			System.out.println("\n");
			
		}

	}
		
	public void WriteResult() {
		
		Lesson l;
		File file = new File("Schedule.txt");
		int num;
		String line = null;
		try {
		
			FileWriter fw = new FileWriter(file);
			
			for (int i = 0; i < 7; i++) {
			
				for (int j = 0; j < 45; j++) {
				
					num = schedule[i][j];
					
					for(int k = 0; k < Lessons.size(); k++) {
					
						l = Lessons.get(k);
						if (l.getCode() == num) {
							
							line = l.getName();
							fw.write(line+ " ");
						}
					
					}
					
				}
					
					fw.write(System.lineSeparator());
			
			}
			
			fw.close();
			
		} catch (IOException e) {

			e.printStackTrace();

		} 

	}
	
	public boolean moveUp() {
	
		if (this.currentX == 0 || this.schedule[currentX - 1][currentY] != 0) {
			
			return false;
		
		}else {
		
			return true;
		}
	
	}
	
	public boolean moveDown() {
	
		if (this.currentX == 6 || this.schedule[currentX + 1][currentY] != 0) {
			
			return false;
		
		}else {
		
			return true;
		}
	
	}
	
	public boolean moveLeft() {
	
		if (this.currentY == 0 || this.schedule[currentX][currentY - 1] != 0) {
			
			return false;
		
		}else {
		
			return true;
		}
	
	}
	
	public boolean moveRight() {
	
		if (this.currentY == 44 || this.schedule[currentX][currentY + 1] != 0) {
			
			return false;
		
		}else {
		
			return true;
		}
	
	}
	
	public ArrayList<State> getChildren() {
	
		ArrayList<State> children = new ArrayList<State>();
		State child = new State(this.schedule,this.currentX,this.currentY);
		
		if(child.moveUp()){
			
			child = new State(child.schedule,this.getcurrentX() - 1,this.currentY);
			children.add(child);
			
		}
		
		if(child.moveDown()) {
			
			child = new State(child.schedule,this.getcurrentX() + 1,this.currentY);
			children.add(child);
			
		}
		
		if(child.moveLeft()) {
			
			child = new State(child.schedule,this.currentX,this.getcurrentY() - 1);
			children.add(child);

		}
		
		if(child.moveRight()) {
			
			child = new State(child.schedule,this.currentX,this.getcurrentY() + 1) ;
			children.add(child);
			
		}
		
		return children;
	
	}
	
	public int generateLesson (int i,int j) {
		
		Random rgen = new Random();
		int lescode = 0;
		
		if (this.data[j] == "A1" || this.data[j] == "A2" || this.data[j] == "A3") {
		
			lescode = rgen.nextInt(10) + 1;
		
		} else if (this.data[j] == "B1" || this.data[j] == "B2" || this.data[j] == "B3") {
		
			lescode = rgen.nextInt(10) + 11;
		
		} else {
		
			lescode = rgen.nextInt(10) + 21;
		
		}
		
		return lescode;
	
	}
	
	public int calculate() {
		
		int score = 0;
		Lesson l = null;
		Teacher t = null;
		int info = this.schedule[currentX][currentY];
		int info1 = this.currentY;
		
		for (int i = 0; i < Lessons.size(); i++) {
		
			l = Lessons.get(i);
			if (l.getCode() == info) {
			
				break;
			
			}
		
		}
		
		for (int i = 0; i < Teachers.size(); i++) {
		
			t = Teachers.get(i);
			if (t.getCodeLesson() == info) {
			
				break;
			
			}
		
		}
		
		if (data[info1] == "A1") {
		
			l.sethoursForFirst(l.gethoursForFirst() - 1);
			
			if (l.gethoursForFirst() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 1] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 2]) {
			
				score = score + 1000;
			
			}
		
		}else if (data[info1] == "A2") {
		
			l.sethoursForSecond(l.gethoursForSecond() - 1);
			
			if (l.gethoursForSecond() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY - 1] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 1]) {
			
				score = score + 1000;
			
			}
		
		}else if (data[info1] == "A3") {
		
			l.sethoursForThird(l.gethoursForThird() - 1);
			
			if (l.gethoursForThird() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY - 2] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY -1]) {
			
				score = score + 1000;
			
			}
		
		}else if (data[info1] == "B1") {
		
			l.sethoursForFirst(l.gethoursForFirst() - 1);
			
			if (l.gethoursForFirst() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 1] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 2]) {
			
				score = score + 1000;
			
			}
		
		}else if (data[info1] == "B2") {
		
			l.sethoursForSecond(l.gethoursForSecond() - 1);
			
			if (l.gethoursForSecond() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY - 1] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 1]) {
			
				score = score + 1000;
			
			}
		
		}else if (data[info1] == "B3") {
		
			l.sethoursForThird(l.gethoursForThird() - 1);
			
			if (l.gethoursForThird() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY - 2] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY -1]) {
			
				score = score + 1000;
			
			}
		
		}else if (data[info1] == "C1") {
		
			l.sethoursForFirst(l.gethoursForFirst() - 1);
			
			if (l.gethoursForFirst() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 1] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 2]) {
			
				score = score + 1000;
			
			}
			
		}else if (data[info1] == "C2") {
		
			l.sethoursForSecond(l.gethoursForSecond() - 1);
			
			if (l.gethoursForSecond() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY - 1] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY + 1]) {
			
				score = score + 1000;
			
			}
		
		}else {
		
			l.sethoursForThird(l.gethoursForThird() - 1);
			
			if (l.gethoursForThird() < 0) {
			
				score = score + 1000;
			
			}
			
			if (this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY - 2] || this.schedule[this.currentX][this.currentY] == this.schedule[this.currentX][this.currentY -1]) {
			
				score = score + 1000;
			
			}
		
		}
		
		t.setMaxHoursPerDay(t.getMaxHoursPerDay() - 1);
		
		if (t.getMaxHoursPerDay() < 0) {
		
			score = score + 1000; 
		
		}
		
		t.setMaxHoursPerWeek(t.getMaxHoursPerWeek() - 1);
		
		if (t.getMaxHoursPerWeek() < 0) {
		
			score = score + 1000; 
		
		}
		
		int counter = 0;
		int lessoncounter = 0;
		while (counter < 6) {
		
			if (l.getCode() == schedule[counter][info1]) {
			
				lessoncounter++;
			
			}
		
			counter++;
		
		}
		
		if (lessoncounter >= 3) {
		
			score = score + 100;
		
		}
		
		boolean found = false;
		int teachercount = 0;
		
		for (int i = 0; i < 6; i++) {
		
			for (int j = info1/9 *9; j < info1/9 *9 + 8; j++) {
			
				if (this.schedule[i][j] == t.getCodeLesson()) {
					
					found = true;
					teachercount++;
					break;
				
				}
				
				if (j == info1/9 *9 + 8 && (this.schedule[i][j] != t.getCodeLesson()) ) {
				
					found = false;
					teachercount = 0;
				
				}
			
			}
			
			if (found == true && teachercount > 2 ) {
			
				score = score + 100;
			
			}
		
		}
		
		return score;
	
	}

}