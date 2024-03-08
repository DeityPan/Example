package com.example.storage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("tb_storage")
public class Storage {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String commodityCode;

    private Integer count;
}
