import java.util.Scanner;

public class EmployeeEarnings
{
  public static void main(String[] args)
  {
    EmployeeEarnings[] earnings;
    int employeeAmount = 0;

    Scanner in = new Scanner(System.in);

    System.out.print("Enter the number of employees: ");
    employeeAmount = in.nextInt();
    in.nextLine();
    earnings = new EmployeeEarnings[employeeAmount];
    int count = 0;

    while (count < employeeAmount)
    {

      // create a report
      EmployeeEarnings employee = new EmployeeEarnings();

      // get employee name from user
      System.out.print("Enter the employee's name: ");
      String name = in.nextLine();


      // set employee name
      // earnings[count].setEmployeeName(name);
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
          System.out.print("Enter the hourly rate for " + name + ": ");
          double rate = in.nextDouble();

          // set the hourly rate
          employee.setHourlyRate(rate);
          valid = true;

          // get hours worked from user
          System.out.print("How many hours did " + name + " work? ");
          double hours = in.nextDouble();

          // set hours worked
          employee.setHoursWorked(hours);

          // calc the hourly workers pay
          employee.calcTotalHourlyPay(hours, rate);
        }
        else if (employeeType.equals("salary"))
        {
          // get the salary rate from user
          System.out.print("Enter the salary for " + name + ": ");
          double rate = in.nextDouble();

          // set the salary rate
          employee.setSalary(rate);
          valid = true;
        }
        else if (employeeType.equals("commission"))
        {
          // get the sales
          System.out.print("Enter the amount of weekly sales: ");
          double sales = in.nextDouble();

          // set the sales
          employee.setCommission(sales);
          valid = true;
        }
        else
          System.out.println("Enter a valid input.");
      }

      // add the employee to the array
      earnings[count] = employee;

      // increment the count to next employee
      count++;

      in.nextLine();
    }
    boolean finished = false;
    while (!finished)
    {
      System.out.print(
          "Would you like to reward a salaried employee with a 10% bonus? (y/n): ");
      String bonus = in.nextLine();
      if (bonus.equals("y") || bonus.equals("Y"))
      {
        System.out.print(
            "Enter the name of the employee you would like to reward: ");
        String rewardedEmployee = in.nextLine();

        for (int i = 0; i < count; i++)
        {
          if (earnings[i].employeeName.equals(rewardedEmployee))
          {
            earnings[i].salary *= 1.1;
            earnings[i].salaryBonus = true;
            System.out.println(rewardedEmployee +
                               " has been rewarded with a 10% bonus.");
          }
        }
      }
      else if (bonus.equals("n") || bonus.equals("N"))
      {
        finished = true;
      }
    }
    printEmployees(earnings, count);
  }
  public static double calcTotalPay(EmployeeEarnings[] earnings, int count)
  {
    // calc total pay from each worker in the array
    double sum = 0;
    for (int i = 0; i < count; i++)
    {
      sum += earnings[i].totalPay + earnings[i].salary;
    }
    return sum;
  }
  public static void printEmployees(EmployeeEarnings[] earnings, int count)
  {
    System.out.println(
        "======================================================================================");
    System.out.println(
        "Name\t\tClass\t\tHours\tSales\t\tRate\tWeekly Pay Amount");
    for (int i = 0; i < count; i++)
    {
      // if hourly worker
      if (earnings[i].hourlyRate > 0)
      {
        System.out.printf("%s\t\thourly\t\t%.2f\t\t\t$%.2f\t$%.2f\n",
                          earnings[i].employeeName, earnings[i].hoursWorked,
                          earnings[i].hourlyRate, earnings[i].totalPay);
      }
      // if salary worker
      else if (earnings[i].salary > 0)
      {

        System.out.printf("%s\t\tsalary\t\t\t\t\t\t", earnings[i].employeeName);
        if (earnings[i].salaryBonus)
        {

          System.out.printf("$%.2f*\n", earnings[i].salary);
        }
        else

          System.out.printf("$%.2f\n", earnings[i].salary);
      }
      // if commission worker
      else if (earnings[i].commission > 0)
      {

        System.out.printf("%s\t\tcommission\t\t$%.2f\n",
                          earnings[i].employeeName,
                          earnings[i].commission * 0.2);
      }
    }
    System.out.println(
        "======================================================================================");

    System.out.printf("\t\t\t\t\t\t\tTOTAL\t$%.2f\n",
                      calcTotalPay(earnings, count));
  }

  // attributes
  double hoursWorked = 0.0;
  double hourlyRate = 0.0;
  double totalPay = 0.0;
  double salary = 0.0;
  double commission = 0.0;
  String employeeName = "";
  boolean salaryBonus = false;

  double getHourlyRate() { return hourlyRate; }
  double getSalary() { return salary; }
  String getEmployeeName() { return employeeName; }
  double getHoursWorked() { return hoursWorked; }
  double getCommission() { return commission; }
  void setHourlyRate(double rate) { hourlyRate = rate; }
  void setSalary(double rate) { salary = rate; }
  void setEmployeeName(String name) { employeeName = name; }
  void setHoursWorked(double hours) { hoursWorked = hours; }
  void setCommission(double commiss) { commission = commiss; }
  double calcTotalHourlyPay(double hours, double rate)
  {
    if (hours < 40)
    {
      totalPay = hours * rate;
    }
    else if (hours > 40)
    {
      double overtimeHours = hours - 40;
      double overtimePay = rate * 2;
      totalPay = (hours * rate) + (overtimeHours * overtimePay);
    }
    return totalPay;
  }
}
