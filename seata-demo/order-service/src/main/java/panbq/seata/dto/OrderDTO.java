package panbq.seata.dto;

import lombok.Data;

@Data
public class OrderDTO {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 产品代码
     */
    private String commodityCode;
    private Integer count;
}
