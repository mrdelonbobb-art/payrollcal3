package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PayrollCalculator {

    public static void main(String[] args) {
        final String FILE_NAME = "employees.txt"; // or full path if needed

        // Step 1: Read all employee data from the file
        Employee[] employees = new Employee[100]; // up to 100 employees
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                if (tokens.length == 4) {
                    int id = Integer.parseInt(tokens[0]);
                    String name = tokens[1];
                    double hours = Double.parseDouble(tokens[2]);
                    double rate = Double.parseDouble(tokens[3]);

                    employees[count++] = new Employee(id, name, hours, rate);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Step 2: Prompt the user for an employee ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an employee ID to get gross pay: ");
        int inputId = scanner.nextInt();
        scanner.close();

        // Step 3: Search for the employee
        boolean found = false;
        for (int i = 0; i < count; i++) {
            Employee emp = employees[i];
            if (emp.getEmployeeId() == inputId) {
                System.out.printf("Employee: %s%nGross Pay: $%.2f%n",
                        emp.getName(), emp.getGrossPay());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + inputId + " not found.");
        }
    }
}
