import java.util.Scanner;

public class EmployeeEarnings
{
  public static void main(String[] args)
  {
    boolean finished = false;
    EmployeeEarnings[] earnings;
    int employeeAmount = 0;

    Scanner in = new Scanner(System.in);

    System.out.print("Enter the number of employees: ");
    employeeAmount = in.nextInt();
    earnings = new EmployeeEarnings[employeeAmount];

    while (finished != true)
    {

      // create a report
      EmployeeEarnings employee = new EmployeeEarnings();

      // get employee name from user
      System.out.print("Enter the employee's name: ");
      String name = in.next();

      // set employee name
      employee.setEmployeeName(name);

      // determine type of worker
      boolean valid = false;
      while (valid == false)
      {
        System.out.print(
            "Enter type of employee (hourly, salary, or commission): ");
        String employeeType = in.next();
        if (employeeType.equals("hourly"))
        {
          // get the hourly rate from user
          // set the hourly rate
          valid = true;
        }
        else if (employeeType == "salary")
        {
          // get the salary rate from user
          // set the salary rate
          valid = true;
        }
        else if (employeeType == "commission")
        {
          valid = true;
        }
        else
          System.out.println("Enter a valid input.");
      }

      // get hours worked from user
      // set hours worked

      // add the employee to the array

      // if no more employees, finished = true
    }
  }

  // attributes
  double hoursWorked = 0.0;
  double hourlyRate = 0.0;
  double salary = 0.0;
  String employeeName = "";

  double getHourlyRate() { return hourlyRate; }
  double getSalary() { return salary; }
  String getEmployeeName() { return employeeName; }
  double getHoursWorked() { return hoursWorked; }
  void setHourlylRate(double rate) { hourlyRate = rate; }
  void setSalary(double rate) { salary = rate; }
  void setEmployeeName(String name) { employeeName = name; }
  void setHoursWorked(double hours) { hoursWorked = hours; }
}
