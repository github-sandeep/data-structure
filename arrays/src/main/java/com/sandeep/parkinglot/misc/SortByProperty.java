package com.sandeep.parkinglot.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByProperty {

   public static void main(String args[]) {
      Employee emp1 = new Employee();
      emp1.setName("rahul");
      emp1.setAge(15);
      emp1.setCode("emp1");

      Employee emp2 = new Employee();
      emp2.setName("john");
      emp2.setAge(20);
      emp2.setCode("emp2");

      Employee emp3 = new Employee();
      emp3.setName("sandeep");
      emp3.setAge(12);
      emp3.setCode("emp3");

      Employee emp4 = new Employee();
      emp4.setName("ankit");
      emp4.setAge(15);
      emp4.setCode("emp4");

      Employee emp5 = new Employee();
      emp5.setName("mohit");
      emp5.setAge(18);
      emp5.setCode("emp5");

      List<Employee> employees = new ArrayList<>();
      employees.add(emp1);
      employees.add(emp2);
      employees.add(emp3);
      employees.add(emp4);
      employees.add(emp5);

      System.out.println("before sorting: ");
      for(Employee emp : employees) {
         System.out.print(emp.getName() + ": " + emp.getAge() + " , ");
      }

      Collections.sort(employees);
      //Collections.reverse(employees);

      System.out.println("\nafter sorting: ");
      for(Employee emp : employees) {
         System.out.print(emp.getName() + ": " + emp.getAge() +  " , ");
      }
   }
}
