package TaskManagementSystem;

public class TaskManagementTest {
    public static void main(String[] args) {
        SingleLinkedList taskList = new SingleLinkedList();

        // Test data
        Task task1 = new Task("T001", "Design Database", "Pending");
        Task task2 = new Task("T002", "Develop API", "In Progress");
        Task task3 = new Task("T003", "Test Application", "Pending");
        Task task4 = new Task("T004", "Deploy Application", "Completed");

        // Add tasks
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(task4);

        // Traverse tasks
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search for a task
        System.out.println("\nSearch for Task T003:");
        Task foundTask = taskList.searchTask("T003");
        if (foundTask != null) {
            System.out.println("Task found: " + foundTask);
        } else {
            System.out.println("Task not found.");
        }

        // Delete a task
        System.out.println("\nDelete Task T002:");
        taskList.deleteTask("T002");
        taskList.traverseTasks();
    }

}
