package com.example.storage.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.storage.dto.StorageDTO;
import com.example.storage.mapper.StorageMapper;
import com.example.storage.model.Storage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class StorageService {
    @Resource
    private StorageMapper storageMapper;

    public Map<String, Object> reduce(StorageDTO storageDTO) {
        String commodityCode = storageDTO.getCommodityCode();
        Integer orderCount = storageDTO.getCount();
        UpdateWrapper<Storage> uw = new UpdateWrapper<>();
        uw.eq("commodity_code", commodityCode);
        Storage realStorage = storageMapper.selectOne(uw);
        Storage storage = new Storage();
        storage.setCount(realStorage.getCount() - orderCount);
        storageMapper.update(storage, uw);

        Map<String, Object> result = new HashMap<>();
        result.put("code", "000000");
        result.put("msg", "success");
        return result;
    }
}
