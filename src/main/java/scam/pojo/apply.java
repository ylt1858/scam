package scam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class apply {
    /**
     * mysql中数据类型：
     * eventName varchar(255),
     * teamNumber int,
     * teamName varchar(20),
     * sno varchar(20),
     * id  int
     */
    private String eventName;
    private Integer teamNumber;
    private String teamName;
    private String sno;
    private Integer id;
}
