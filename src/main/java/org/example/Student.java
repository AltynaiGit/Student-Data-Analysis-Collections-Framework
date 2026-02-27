package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private long id;
    private String name;
    private String groupName;
    private List<Integer> grades;

    public Student(long id, String name, String groupName, List<Integer> grades) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
        this.grades = grades;
    }

    public Student() {
    }

   double calculateAverage() {
        int graDes = 0;
        for (Integer gr : grades) {
            graDes += gr;
        }
       return (double) graDes / grades.size();
   }

    public int countTopGrades() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }
}