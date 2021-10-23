package com.sandeep.misc;

public class Employee implements Comparable<Employee>{
   private String name;
   int age;
   String code;

   public String getCode() {

      return code;
   }

   public void setCode(String code) {

      this.code = code;
   }

   public String getName() {

      return name;
   }

   public void setName(String name) {

      this.name = name;
   }

   public int getAge() {

      return age;
   }

   public void setAge(int age) {

      this.age = age;
   }

   @Override
   public int compareTo(Employee emp) {
      //return this.age - emp.getAge();
      int byAge = this.age - emp.getAge();
      if(byAge == 0) {
         return compareByName(emp.getName());
      }
      return byAge;
   }

   private int compareByName(String name) {
      return this.name.compareTo(name);
   }
}
