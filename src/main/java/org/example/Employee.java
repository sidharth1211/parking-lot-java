package org.example;

public class Employee {
    private String name;
    private int age;
    private String designation;
    int salary;

    public Employee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public int getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Employee empOne = new Employee("James Smith");
        Employee empTwo = new Employee("Mary Anne");

        // Invoking methods for each object created
        empOne.setAge(26);
        empOne.setDesignation("Senior Software Engineer");
        empOne.setSalary(1000);
        System.out.println("Employee One:");
        System.out.println(empOne.toString());

        empTwo.setAge(21);
        empTwo.setDesignation("Software Engineer");
        empTwo.setSalary(500);
        System.out.println("Employee Two:");
        System.out.println(empTwo.toString());
    }
}