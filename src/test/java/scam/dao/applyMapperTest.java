package scam.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import scam.pojo.apply;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class applyMapperTest {

    @Autowired
    private applyMapper applyMapper;
    @Test
    void applyList() {
        List<apply> applies = applyMapper.applyList();
        for (apply apply : applies) {
            System.err.println(apply.toString());
        }
    }

    @Test
    void getApply() {
        apply apply = applyMapper.getApply(1);
        System.err.println(apply);
    }

    @Test
    //回滚
    @Transactional
    void addApply() {
        int i = applyMapper.addApply(new apply("2020数学竞赛", 6, "five_team","1001",100));
        System.err.println(i + "添加成功！");
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void deleteApply() {
        int i = applyMapper.deleteApply(1);
        System.err.println(i + "删除成功！");
        assertTrue(i > 0);
    }

    @Test
    @Transactional
    void updateApply() {
        int test_team = applyMapper.updateApply(new apply("2020数学竞赛", 1,
                "test_team", "1001", 1));
        System.err.println(test_team  + "更新成功！");
        assertTrue(test_team > 0);
    }
}