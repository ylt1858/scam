package scam.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author y'l'l
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardWinning {
    /**
     * mysql中数据类型
     * teamNumber int,
     * grade int,(1-7:金、银、铜、特等奖、一、二、三)
     * total int,
     * id int,
     */
    private int id;
    private int teamNumber;
    private int grade;
    private int total;
}
