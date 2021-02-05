package scam.dao;

import org.springframework.stereotype.Repository;
import scam.pojo.apply;
import scam.pojo.match;

import java.util.List;

@Repository
public interface applyMapper {
    List<apply> applyList();
    apply getApply(String eventName, String sno ,String tno);
    int addApply(apply apply);
    int deleteApply(String eventName, String sno ,String tno);
    int updateApply(apply apply);
}
