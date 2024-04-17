package org.example;

public class Student {
    private String name;
    private String speciality;
    private Grade[] grades;

    public Student(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
        grades = new Grade[5];
    }

    public void info() {
        System.out.println("Name: " + name + " speciality: " + speciality);
    }

    public void showAllGrades() {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] != null) {
                grades[i].info();
            }
        }
    }

    private int findEmptyIndex() {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addNewGrade(String subject, int mark) {
        Grade newGrade = new Grade(subject, mark);
        int index = findEmptyIndex();
        if (index != -1) {
            grades[index] = newGrade;
        } else {
            System.out.println("Sorry empty box not found");
        }
    }

    public void showMaxGrade() {
        Grade maxGrade = grades[0];
        for (int i = 0; i < grades.length; i++) {
            if(grades[i] != null) {
                if (maxGrade.getMark() < grades[i].getMark()) {
                    maxGrade = grades[i];
                }
            }
        }
        maxGrade.info();
    }

    public String getName() {
        return name;
    }
}
