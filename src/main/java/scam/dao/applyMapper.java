package scam.dao;

import org.springframework.stereotype.Repository;
import scam.pojo.apply;
import scam.pojo.match;
import scam.pojo.student;

import java.util.List;

/**
 * @author admin
 */
@Repository
public interface applyMapper {
    /**
     * 查找所有报名信息
     * @return apply List
     */
    List<apply> applyList();

    /**
     * 通过id查找
     * @param id 赛事id
     * @return apply
     */
    apply getApply(int id);

    /**
     * 添加报名
     * @param apply 报名
     * @return int
     */
    int addApply(apply apply);

    /**
     * 通过id删除
     * @param id 赛事id
     * @return int
     */
    int deleteApply(int id);

    /**
     * 更新报名
     * @param apply 报名
     * @return int
     */
    int updateApply(apply apply);

    /**
     * 通过赛事id查找学生
     * @param id 赛事id
     * @return student List
     */
    List<student> queryStudentByApply(int id);
}
