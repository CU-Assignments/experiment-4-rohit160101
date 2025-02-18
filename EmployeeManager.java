import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
    }

    public void updateEmployee() {
        System.out.print("Enter ID of employee to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new Salary: ");
                double salary = scanner.nextDouble();
                emp.setName(name);
                emp.setSalary(salary);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void removeEmployee() {
        System.out.print("Enter ID of employee to remove: ");
        int id = scanner.nextInt();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee removed.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void searchEmployee() {
        System.out.print("Enter ID of employee to search: ");
        int id = scanner.nextInt();
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manager.addEmployee();
                    break;
                case 2:
                    manager.updateEmployee();
                    break;
                case 3:
                    manager.removeEmployee();
                    break;
                case 4:
                    manager.searchEmployee();
                    break;
                case 5:
                    manager.displayEmployees();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
