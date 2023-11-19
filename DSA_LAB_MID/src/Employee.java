import org.w3c.dom.Node;

public class Employee {
    int employeeId;
    String employeeName;
    Employee next;
    Employee head = null;


    Employee() {
    }

    Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.next = null;
    }

    public void addEmployee(int id, String name) {
        Employee newEmployee = new Employee(id, name);
        if (head == null) {
            head = newEmployee;
        } else {
            Employee current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEmployee;
        }
    }

    public void searchEmployee(int id) {
        if (head == null) {
            System.out.println("No Employee is added");
        } else {
            Employee current = head;
            while (current.next != null) {
                if (id == current.employeeId) {
                    System.out.println("Employee Information:");
                    System.out.println("Employee ID: " + current.employeeId);
                    System.out.println("Employee name:" + current.employeeName);
                    break;
                }
                current = current.next;
            }
        }
    }
    public void removeDuplicates(){
        Employee ptr = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.employeeId == ptr.next.employeeId) {
                ptr.next = ptr.next.next;
            }
            ptr = ptr.next;
        }
    }
    public void insertAtPosition(int id ,String newName) {
            if (head == null) {
                System.out.println("No record in the list");
            }
            else {
                Employee current = head;

                int nodeCount = 0;
                while (current != null) {
                    nodeCount = nodeCount + 1;
                    if (nodeCount == id) {
                        current.employeeName = employeeName;
                        break;
                    }
                    current = current.next;
                }
            }
    }
    public void display(){
        Employee current = head;
        while(current!=null){
            System.out.println("Employee ID: " +current.employeeId);
            System.out.println("Employee Name: "+current.employeeName);
            current = current.next;

        }
    }

}


