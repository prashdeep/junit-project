package com.hexaware.model;

import java.util.*;
import java.util.Objects;
import java.time.LocalDate;
import org.skife.jdbi.v2.DBI;
import com.hexaware.persistence.*;

public class Student {
    private int id;
    private String name;
    private int grade;
    private LocalDate startDate;
    private StudentDAO dao =  null;;

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

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getStartDate(){
        return this.startDate;
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

  public List<Student> fetchAllStudents(StudentDAO dao){
      System.out.println("********************");
      System.out.println("Came inside the fetchAllStudents method");
      System.out.println(dao);
      System.out.println("********************");
        List<Student> studentsList = dao.list();
        if (studentsList != null ){
            for(Student student: studentsList){
                System.out.println(student.getName());
                System.out.println(student.getId());
                System.out.println(student.getGrade());
            }
        }
        return studentsList;
  }

  public void fetchStudentById( int id){
        List<Student> studentsList = dao.findById(id);
        for(Student student: studentsList){
            System.out.println(student.getName());
            System.out.println(student.getId());
            System.out.println(student.getGrade());
        }
  }

  public static final DBI getConnect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      DBI dbi = new DBI("jdbc:mysql://localhost/training?useSSL=false", "root", "welcome");
      return dbi;
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}