package MVCPatternExample;

public class MVCPatternTest {
    public static void main(String[] args) {
        Student model = new Student("1001", "Devdan Banik", "A+");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.update();

        controller.setStudentId("1008");
        controller.setStudentGrade("O");

        controller.update();
    }

}
