package scam.dao;

import org.springframework.stereotype.Repository;
import scam.pojo.instructor;

import java.util.List;

/**
 * @author y'l'l
 */
@Repository
public interface InstructorMapper {
    /**
     * 获取所有指导老师
     * @return
     */
    List<instructor> instructorList();

    /**
     * 查找指导老师
     * @param tno
     * @return
     */
    instructor getInstructor(String tno, int teamNumber);

    /**
     * 添加指导老师
     * @return
     */
    int addInstructor(instructor instructor);

    /**
     * 删除指导老师
     * @param tno
     * @param teamNumber
     * @return
     */
    int deleteInstructor(String tno,Integer teamNumber);

    /**
     * 更新指导老师
     * @param instructor
     * @return
     */
    int updateInstructor(instructor instructor);

}
