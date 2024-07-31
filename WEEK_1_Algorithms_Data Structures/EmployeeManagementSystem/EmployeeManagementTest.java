package EmployeeManagementSystem;

public class EmployeeManagementTest {
    public static void main(String[] args) {
        // Initialize the EmployeeManagement system with a capacity of 5
        EmployeeManagement management = new EmployeeManagement(5);

        // Test data
        Employee emp1 = new Employee("E001", "Alice", "Manager", 75000);
        Employee emp2 = new Employee("E002", "Bob", "Developer", 50000);
        Employee emp3 = new Employee("E003", "Charlie", "Designer", 60000);
        Employee emp4 = new Employee("E004", "David", "Tester", 45000);
        Employee emp5 = new Employee("E005", "Eve", "Support", 40000);

        // Add employees
        management.addEmployee(emp1);
        management.addEmployee(emp2);
        management.addEmployee(emp3);
        management.addEmployee(emp4);
        management.addEmployee(emp5);

        // Traverse employees
        System.out.println("All Employees:");
        management.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearch for Employee E003:");
        Employee foundEmployee = management.searchEmployee("E003");
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete an employee
        System.out.println("\nDelete Employee E002:");
        management.deleteEmployee("E002");
        management.traverseEmployees();
    }

}
