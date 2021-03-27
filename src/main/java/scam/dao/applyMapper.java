package scam.dao;

import org.springframework.stereotype.Repository;
import scam.pojo.apply;
import scam.pojo.match;

import java.util.List;

/**
 * @author admin
 */
@Repository
public interface applyMapper {
    /**
     * 查找所有报名信息
     * @return
     */
    List<apply> applyList();

    /**
     * 通过id查找
     * @param id id
     * @return
     */
    apply getApply(int id);

    /**
     * 添加报名
     * @param apply
     * @return
     */
    int addApply(apply apply);

    /**
     * 通过id删除
     * @param id id
     * @return
     */
    int deleteApply(int id);

    /**
     * 更新报名
     * @param apply
     * @return
     */
    int updateApply(apply apply);
}
