package scam.dao;

import org.springframework.stereotype.Repository;
import scam.pojo.match;

import java.util.List;

@Repository
public interface MatchMapper {
    List<match> matchList();
    match getMatch(String name);
    int addMatch(match match);
    int deleteMatch(String name);
    int updateMatch(match match);
}
