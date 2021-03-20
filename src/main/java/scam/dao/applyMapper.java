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
     * 通过主码查找
     * @param eventName 赛事名称
     * @param sno   学号
     * @param tno   教师编号
     * @return
     */
    apply getApply(String eventName, String sno ,String tno);

    /**
     * 添加报名
     * @param apply
     * @return
     */
    int addApply(apply apply);

    /**
     * 删除报名
     * @param eventName
     * @param sno
     * @param tno
     * @return
     */
    int deleteApply(String eventName, String sno ,String tno);

    /**
     * 更新报名
     * @param apply
     * @return
     */
    int updateApply(apply apply);
}
