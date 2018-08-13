package com.hexaware.model;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int grade;

    public Student(int id, String name, int grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getGrade(){
        return this.grade;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
        return false;
        }
        if (getClass() != obj.getClass()) {
        return false;
        }
        Student student = (Student) obj;
        if (Objects.equals(id, student.getId())
            && Objects.equals(name, student.getName())
            && Objects.equals(grade, student.getGrade())) {
        return true;
        }
        return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(id, name, grade);
  }

  @Override
  public String toString(){
      return "{ id: "+id+", "+" name: "+name+", "+ " grade: "+grade+"}";
  }


}