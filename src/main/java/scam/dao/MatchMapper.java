package scam.dao;

import org.springframework.stereotype.Repository;
import scam.pojo.match;

import java.util.List;

/**
 * @author y'l'l
 */
@Repository
public interface MatchMapper {
    /**
     * 赛事列表
     * @return
     */
    List<match> matchList();

    /**
     * 通过名字查找赛事
     * @param name
     * @return
     */
    match getMatch(String name);

    /**
     * 添加赛事
     * @param match
     * @return
     */
    int addMatch(match match);

    /**
     * 删除赛事
     * @param name
     * @return
     */
    int deleteMatch(String name);

    /**
     * 更新赛事
     * @param match
     * @return
     */
    int updateMatch(match match);
}
