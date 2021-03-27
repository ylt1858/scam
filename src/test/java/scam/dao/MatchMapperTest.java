package scam.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import scam.pojo.match;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MatchMapperTest {

    @Autowired
    protected MatchMapper matchMapper;

    @Test
    void matchList() {
        List<match> matches = matchMapper.matchList();
        matches.forEach(System.err::println);
    }

    @Test
    void getMatch() {
        match match = matchMapper.getMatch("2020数学竞赛");
        System.err.println(match);
    }

    @Test
    @Transactional
    void addMatch() {
        int i = matchMapper.addMatch(new match(Date.valueOf(LocalDate.now()),"test-tests","test",
                "test",1,1));
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void deleteMatch() {
        int i = matchMapper.deleteMatch("test");
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void updateMatch() {
        int i = matchMapper.updateMatch(new match(Date.valueOf(LocalDate.now()),"2020数学竞赛","test",
                "test",1,1));
        assertTrue(i > 0);
    }
}