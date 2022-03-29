package Assignment2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentController {
	
	private StudentModel model;
	private StudentView view;
	private Database handler;
	
	StudentController(StudentModel model, StudentView view){
		this.model = model;
		this.view = view;
	}
	
	public void deleteData(int id) throws SQLException{

		handler = Database.getInstance();
		
		String qu = "DELETE FROM STUDENT WHERE id = " + id;
		
		if(handler.execAction(qu)) {
			System.out.println("Data deleted!");
		}
	}
	
	public void updateData(int id, String stmt) throws SQLException{
		handler = Database.getInstance();
		
		String qu = "UPDATE STUDENT SET " + stmt + " where id = " + id;
		System.out.println(qu);
		
		if(handler.execAction(qu)) {
			System.out.println("Successfully update the data into the database");
		} else {
			System.out.println("Data update failed successfully");
		}
	}
	
	public void addData(int id, String name, String department, double math, double science) throws SQLException {
		
		handler = Database.getInstance();
		
		String qu = "INSERT INTO STUDENT VALUES ("
				+ id + ", '" + name + "',"
				+ "'" + department + "',"
				+ math + "," + science + ")";
		
		if(handler.execAction(qu)) {
			System.out.println("Successfully add the data into the database");
		} else {
			System.out.println("Data adding failed successfully");
		}
	}

	public void loadAll() throws SQLException{
		handler = Database.getInstance();
		
		String qu = "SELECT * FROM STUDENT";
		ResultSet rs = handler.execQuery(qu);
		
		System.out.println("Exam Mark for all student:");
		
		System.out.print("Matrics ID" + "\t");
		System.out.print("Student Name" + "\t" + "\t");
		System.out.print("Department" + "\t");
		System.out.print("Mathematics" + "\t");
		System.out.println("Science" + "\t");
		
		while(rs.next()) {
			System.out.print(rs.getInt("id") + "\t" + "\t");
			System.out.print(rs.getString("nameStudent")  + "\t");
			System.out.print(rs.getString("department")  + "\t" + "\t");
			System.out.print(rs.getDouble("math")  + "\t" + "\t");
			System.out.println(rs.getDouble("science")  + "\t" + "\t");
		}
	}
	
	
	
	public void loadDataAStudent(int id) throws SQLException {
		
		handler = Database.getInstance();
		
		String qu = "SELECT * FROM STUDENT where id = " + id;
		ResultSet rs = handler.execQuery(qu);
		
		while(rs.next()) {
			System.out.println("Student ID: " + rs.getInt("id"));
			System.out.println("Student Name: " + rs.getString("nameStudent"));
			System.out.println("Department: " + rs.getString("department"));
			System.out.println("Mathematics Mark: " + rs.getDouble("math"));
			System.out.println("Science Mark: " + rs.getDouble("science"));
		}
	}
}
