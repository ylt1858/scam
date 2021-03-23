package scam.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import scam.pojo.teacher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherMapperTest {

    @Autowired
    protected TeacherMapper teacherMapper;

    @Test
    void queryTeacherList() {
        List<teacher> teachers = teacherMapper.queryTeacherList();
        teachers.forEach(System.out::println);
    }

    @Test
    void queryTeacherByTno() {
        teacher teacher = teacherMapper.queryTeacherByTno(2001);
        System.err.println(teacher);
    }

    @Test
    @Transactional
    void addTeacher() {
        int i = teacherMapper.addTeacher(new teacher("20011", "name",
                "phone", "111@qq.com"));
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void updateTeacher() {
        int i = teacherMapper.updateTeacher(new teacher("2001", "name",
                "phone", "111@qq.com"));
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void deleteTeacher() {
        int i = teacherMapper.deleteTeacher("2005");
        assertTrue(i > 0);
    }
}