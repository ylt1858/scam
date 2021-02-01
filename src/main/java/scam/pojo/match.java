package scam.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @author y'l'l
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class match {
    /**年度
     * SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
       Date date=new Date();
       sdf.format(date);
     * 名称
     * 主办单位
     * 所属专业
     * 级别(1：国际 2：国家 3：省级)
     * 类别(1:政府 0：学生)
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date times;
    private String raceName;
    private String organizer;
    private String profession;
    private int rank;
    private int category;
}
