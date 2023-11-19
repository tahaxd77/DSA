import java.util.Scanner;

public class FA22_BCS_119 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int choice;

        do {
            System.out.println("EMPLOYEE INFO SYSTEM");
            System.out.println("**********************");
            System.out.println("1. Add an Employee.");
            System.out.println("2. See the Employee details.");
            System.out.println("3. Remove Duplicate.");
            System.out.println("4. Update the employee record.");
            System.out.println("5. Exit");
            choice = s1.nextInt();
            if(choice == 1){
                System.out.println("Enter the Employee ID: ");
                int id = s2.nextInt();
                System.out.println("Enter the Employee Name: ");
                String name = s2.next();
                employee.addEmployee(id,name);
                System.out.println("Employee Added Successfully");
            }
            if (choice == 2){
                System.out.println("Insert the id of employee to search: ");
                int idToSearch = s2.nextInt();
                System.out.println("Employee Found: ");
                employee.searchEmployee(idToSearch);

            }
            if(choice == 3){
                employee.removeDuplicates();
                System.out.println("Duplicate removed successfully");
            }
            if (choice == 4){
                System.out.println("Enter the ID to update: ");
                int idToUpdate = s2.nextInt();
                System.out.println("Enter the name: ");
                String nameToUpdate = s2.next();
                employee.insertAtPosition(idToUpdate,nameToUpdate);
                System.out.println("Employee updated successfully");
            }
        }while (choice != 5);
        System.out.println("Thank you for using the system");
    }
}