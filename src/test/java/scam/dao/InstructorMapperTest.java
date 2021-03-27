package scam.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import scam.pojo.instructor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InstructorMapperTest {

    @Autowired
    protected InstructorMapper instructorMapper;

    @Test
    @Transactional
    void instructorList() {
        List<instructor> instructors = instructorMapper.instructorList();
        instructors.forEach(System.err::println);
    }

    @Test
    @Transactional
    void getInstructor() {
        instructor instructor = instructorMapper.getInstructor("2001", 1);
        System.err.println(instructor);
    }

    @Test
    @Transactional
    void addInstructor() {
        int i = instructorMapper.addInstructor(new instructor("2003", 4, 1));
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void deleteInstructor() {
        int i = instructorMapper.deleteInstructor("2001",3);
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void updateInstructor() {
        int i = instructorMapper.updateInstructor(new instructor("2001", 3, 3));
        assertTrue(i > 0);
    }
}