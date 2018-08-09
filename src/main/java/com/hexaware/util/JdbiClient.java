package com.hexaware.util;

import org.skife.jdbi.v2.DBI;
import com.hexaware.persistence.*;

public class JdbiClient {
    public static void main(String args[]){
    StudentDAO dao =  getConnect().onDemand(StudentDAO.class);
    List<Student> studentList = dao.list();

        for(Student student: studentList){
            System.out.println(student.getName());
        }
    }

   public final DBI getConnect() {
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