package scam.dao;

import org.springframework.stereotype.Repository;
import scam.pojo.AwardWinning;

import java.util.List;

/**
 * @author y'l'l
 */
@Repository
public interface AwardWinningMapper {
    /**
     * 返回获奖表单
     * @return
     */
    List<AwardWinning> awardWinningList();

    /**
     * 通过id查找获奖
     * @param id
     * @return
     */
    AwardWinning getModel(int id);

    /**
     * 通过id删除获奖
     * @param id
     * @return
     */
    int deleteModel(int id);

    /**
     * 添加获奖实体
     * @param awardWinning
     * @return
     */
    int addModel(AwardWinning awardWinning);

    /**
     * 更新获奖信息
     * @param awardWinning
     * @return
     */
    int updateModel(AwardWinning awardWinning);
}
