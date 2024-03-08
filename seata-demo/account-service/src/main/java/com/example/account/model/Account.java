package com.example.account.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("tb_account")
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userId;
    private Integer money;

}
