package com.example.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountDTO {
    private String userId;
    private Integer money;

}
