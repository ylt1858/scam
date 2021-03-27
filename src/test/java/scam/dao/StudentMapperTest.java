package scam.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import scam.pojo.student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    @Transactional
    void queryStudentList() {
        List<student> studentList = studentMapper.queryStudentList();
        for (student s:
             studentList) {
            System.err.println(s);
        }
    }

    @Test
    @Transactional
    void queryStudentBySno() {
        student student = studentMapper.queryStudentBySno("1001");
        System.err.println(student);
    }

    @Test
    @Transactional
    void addStudent() {
        int i = studentMapper.addStudent(new student("1999", "test", 3, "班级",
                "432622199911012586", "652651621654112321", "teamName"));
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void updateStudent() {
        int i = studentMapper.updateStudent(new student("1001", "testUpdate", 3, "班级",
                "432622199911012586", "652651621654112321", "teamName"));
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void deleteStudent() {
        studentMapper.addStudent(new student("11005", "test", 3, "班级",
                "432622199911012586", "652651621654112321", "teamName"));
        int i = studentMapper.deleteStudent("1005");
        assertTrue(i > 0);
    }
}