package com.example.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StorageDTO {
    private String commodityCode;
    private Integer count;
}
