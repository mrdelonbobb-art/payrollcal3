package com.pluralsight;
import java.util.Scanner;

public class PayrollCal {

    public static void main(String[] args) {
        // Step 1: Create some employee records
        Employee[] employees = {
                new Employee(10, "Dana Wyatt", 52.5, 12.50),
                new Employee(20, "Ezra Aiden", 17, 16.75),
                new Employee(30, "Brittany Thibbs", 40, 16.50),
                new Employee(40, "Zephaniah Hughes", 2, 10.0)
        };

        // Step 2: Prompt the user for an employee ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an employee ID to get gross pay: ");
        int inputId = scanner.nextInt();

        // Step 3: Search for the employee
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == inputId) {
                System.out.printf("Employee: %s%nGross Pay: $%.2f%n",
                        emp.getName(), emp.getGrossPay());
                found = true;
                break;
            }
        }

        // Step 4: Handle case if employee is not found
        if (!found) {
            System.out.println("Employee with ID " + inputId + " not found.");
        }

        scanner.close();
    }
}



