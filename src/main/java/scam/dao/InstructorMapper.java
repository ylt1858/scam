package scam.dao;

import org.springframework.stereotype.Repository;
import scam.pojo.instructor;

import java.util.List;

@Repository
public interface InstructorMapper {
    /**
     * 获取所有指导老师
     * @return
     */
    List<instructor> instructorList();

    /**
     * 查找指导老师
     * @return
     */
    instructor getInstructor();

    /**
     * 添加指导老师
     * @return
     */
    int addInstructor();

    /**
     * 删除指导老师
     * @return
     */
    int deleteInstructor(String tno);

    /**
     * 修改指导老师
     * @return
     */
    int updateInstructor();

}
