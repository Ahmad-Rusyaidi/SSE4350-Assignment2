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
		
		String proceed = "";
		
		System.out.println("Proceed into database? y = yes n = no");
		proceed = input.next();
		
		while(proceed.equals("y")) {
			System.out.println("Which procss would you like to choose?");
			System.out.println("1. Add Data" + "\n" + "2. All Students Data" + "\n" + "3. A student's data" + "\n" + "4. Delete data" + "\n" + "5. Update data");
			int choose = input.nextInt();

			switch(choose) {
				case 1:
					System.out.println("What is the student's id?");
					id = Integer.parseInt(input.next());
					System.out.println("What is the student's name?");
					input.nextLine();
					String name = input.nextLine();
					System.out.println(name);

					System.out.println("What is the student's department?");
					String department = input.nextLine();
					System.out.println("What is the student's Science's mark?");
					double scienceMark = input.nextDouble();
					System.out.println("What is the student's Mathematics's mark?");
					double mathematicsMark = input.nextDouble();
					
					controller.addData(id, name, department, mathematicsMark, scienceMark);
					break;
				case 2:
					controller.loadAll();
					break;
				case 3:
					System.out.println("What is the student's id?");
					id = input.nextInt();
					controller.loadDataAStudent(id);
					break;
				case 4:
					System.out.println("What is the student's id?");
					id = input.nextInt();
					controller.deleteData(id);
					break;
				case 5:
					input.nextLine();
					System.out.println("What is the student's id?");
					id = Integer.parseInt(input.nextLine());
					System.out.println("Update Statement:" + "\n" + "Ex: nameStudent = 'Ali' or id = 208775 or math = 99.8");
					String updateData = input.nextLine();
					System.out.println(updateData);
					controller.updateData(id, updateData);
					break;
			}
			
			System.out.println("Continue? y = yes n = no");
			proceed = input.next();
		}
		
		System.out.println("Exit from database!");
	}
}
