package com.example.business.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseBusinessDTO {
    private String userId;
    private String commodityCode;
    private Integer orderCount;
}
