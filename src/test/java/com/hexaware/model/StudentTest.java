package com.hexaware.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class StudentTest{

    private static Student student;
    @BeforeClass
    public static void initializeStudent(){
        student = new Student(12, "Vinay", 4);
    }

    @Test
    public void testSetName(){
        student.setName("Dinesh");
        assertEquals(student.getName(), "Dinesh");
        assertTrue(student.getName().equals("Dinesh"));
    }

    @Test
    public void testStudentConstructor(){
        assertTrue(student.getId() == 12);
        assertEquals(student.getName(), "Vinay");
        assertEquals(student.getGrade(), 4);
    }

    @Test
    public void testEquals(){
        Student student2 = new Student(12, "Vinay", 4);
        Student student3 = new Student(12, "Vinay", 5);
        assertEquals(student, student2);
        assertNotEquals(student, student3);
        assertFalse(student.equals(student3));
    }

    @Test
    public void testHashCode(){
        Student student2 = new Student(12, "Vinay", 4);
        Student student3 = new Student(12, "Vinay", 5);
        assertEquals(student.hashCode(), student2.hashCode());
        assertNotEquals(student2.hashCode(), student3.hashCode());
    }

    @Test
    public void testToString(){
        assertEquals(student.toString(), "{ id: 12,  name: Vinay,  grade: 4}");
    }


}