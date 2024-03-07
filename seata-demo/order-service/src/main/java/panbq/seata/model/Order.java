package panbq.seata.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("tb_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 产品代码
     */
    private String commodityCode;
    private Integer count;
    private Integer money;


}
