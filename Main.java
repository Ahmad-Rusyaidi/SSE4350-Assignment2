package Assignment2;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	
	//private static Database handler;
	
	public static void main(String[] args) throws SQLException{
		
		StudentModel model = new StudentModel();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(model, view);
		
		Database handler = Database.getInstance();
		
		Scanner input = new Scanner(System.in);
		
		int id;
		
		System.out.println("Which procss would you like to choose?");
		System.out.println("1. Add Data" + "\n" + "2. All Students Data" + "\n" + "3. A student's data");
		int choose = input.nextInt();
		
		switch(choose) {
			case 1:
				System.out.println("What is the student's id?");
				id = Integer.parseInt(input.next());
				System.out.println("What is the student's name?");
				String name = input.next();
				input.next();
				System.out.println("What is the student's department?");
				String department = input.next();
				System.out.println("What is the student's Science's mark?");
				double scienceMark = input.nextDouble();
				System.out.println("What is the student's Mathematics's mark?");
				double mathematicsMark = input.nextDouble();
				
				controller.addData(id, name, department, scienceMark, mathematicsMark);
				break;
			case 2:
				controller.loadAll();
				break;
			case 3:
				System.out.println("What is the student's id?");
				id = input.nextInt();
				controller.loadDataAStudent(id);
				break;
		}
	}
}
