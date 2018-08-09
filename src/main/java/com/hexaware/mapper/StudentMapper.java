package com.hexaware.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
import com.hexaware.model.*;

public class StudentMapper implements ResultSetMapper<Student> {


  public final Student map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    Student student = new Student(rs.getInt("STUDENT_ID"),
         rs.getString("STUDENT_NAME"),
         rs.getInt("STUDENT_GRADE"));
    return student;
  }
}
