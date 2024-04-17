package org.example;

import java.util.Scanner;

public class Main {
    static Student[] students = new Student[5];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isWork = true;
        while (isWork){
            System.out.println("1-add new student" +
                    "2-add new grade" +
                    "3-show all students" +
                    "4-show all grades" +
                    "5-get max grade" +
                    "6-quit");
            String answer = scanner.nextLine();
            switch (answer){
                case "1"->addNewStudent();
                case "2"->addNewGrade();
                case "3"->showAllStudents();
                case "4"->getGradesStudent();
                case "5"->getMaxGradesStudent();
                case "6"->isWork=false;
            }
        }

    }

    public static void addNewStudent() {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        System.out.println("Enter student speciality:");
        String speciality = scanner.nextLine();

        Student student = new Student(name, speciality);
        int index = findEmptyIndex();
        if (index != -1) {
            students[index] = student;
        } else {
            System.out.println("Sorry empty box not found");
        }
    }

    public static void showAllStudents() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                students[i].info();
            }
        }
    }

    public static void addNewGrade(){
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter subject:");
        String subject = scanner.nextLine();
        System.out.println("Enter mark:");
        int mark = scanner.nextInt();
        scanner.nextLine();
        Student student = getStudentByName(name);
        student.addNewGrade(subject, mark);
    }
    public static void getGradesStudent() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        Student student = getStudentByName(name);
        student.showAllGrades();
    }
  public static void getMaxGradesStudent() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        Student student = getStudentByName(name);
        student.showMaxGrade();
    }

    public static Student getStudentByName(String fullName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (fullName.equals(students[i].getName())) {
                    return students[i];
                }
            }
        }
        return null;
    }

    private static int findEmptyIndex() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                return i;
            }
        }
        return -1;
    }
}