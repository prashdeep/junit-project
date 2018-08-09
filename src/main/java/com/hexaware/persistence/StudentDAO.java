package com.hexaware.persistence;

import com.hexaware.model.Student;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.mapper.StudentMapper;

public interface StudentDAO {

  @SqlQuery("SELECT * FROM STUDENT")
  @Mapper(StudentMapper.class)
  List<Student> list();


  @SqlQuery("SELECT * FROM STUDENT WHERE STUDENT_ID=:studentId")
  @Mapper(StudentMapper.class)
  List<Student> findById(@Bind("studentId")int studentId);
  void close();
}
