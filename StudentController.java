package Assignment2;

public class StudentController {
	
	private StudentModel model;
	private StudentView view;
	
	StudentController(StudentModel model, StudentView view){
		this.model = model;
		this.view = view;
	}
	
	public int getId() {
		return model.getId();
	}
	public void setId(int id) {
		model.setId(id);
	}
	public String getName() {
		return model.getName();
	}
	public void setName(String name) {
		model.setName(name);
	}
	public double getMathMark() {
		return model.getMathMark();
	}
	public void setMathMark(double mathMark) {
		model.setMathMark(mathMark);
	}
	public double getScienceMark() {
		return model.getScienceMark();
	}
	
	public void setScienceMark(double scienceMark) {
		model.setScienceMark(scienceMark);
	}
	
	public void studentExamMark() {
		view.studentExamMark(model.getId(), model.getName(), model.getMathMark(), model.getScienceMark());
	}
}
