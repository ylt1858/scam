package scam.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import scam.pojo.AwardWinning;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AwardWinningMapperTest {

    @Autowired
    protected AwardWinningMapper awardWinningMapper;

    @Test
    void awardWinningList() {
        List<AwardWinning> awardWinnings = awardWinningMapper.awardWinningList();
        for (AwardWinning awardWinning : awardWinnings) {
            System.err.println(awardWinning.toString());
        }
    }

    @Test
    @Transactional
    void getModel() {
        AwardWinning model = awardWinningMapper.getModel(1);
        System.err.println(model);
    }

    @Test
    @Transactional
    void deleteModel() {
        int i = awardWinningMapper.deleteModel(1);
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void addModel() {
        int i = awardWinningMapper.addModel(new AwardWinning(4,  2, 1000));
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void updateModel() {
        int i = awardWinningMapper.updateModel(new AwardWinning(1,  1, 10001));
        assertTrue(i > 0);
    }
}