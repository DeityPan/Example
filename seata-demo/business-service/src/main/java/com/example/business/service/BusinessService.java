package com.example.business.service;

import com.example.api.OrderDTO;
import com.example.api.StorageDTO;
import com.example.business.dto.PurchaseBusinessDTO;
import com.example.business.feign.OrderFeignClient;
import com.example.business.feign.StorageFeignClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class BusinessService {
    @Resource
    private OrderFeignClient orderFeignClient;
    @Resource
    private StorageFeignClient storageFeignClient;

    public Map<String, Object> purchaseSuccess(PurchaseBusinessDTO purchaseBusinessDTO) {
        String userId = purchaseBusinessDTO.getUserId();
        String commodityCode = purchaseBusinessDTO.getCommodityCode();
        Integer orderCount = purchaseBusinessDTO.getOrderCount();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(userId);
        orderDTO.setCommodityCode(commodityCode);
        orderDTO.setCount(orderCount);
        orderFeignClient.create(orderDTO);
        StorageDTO storageDTO = new StorageDTO();
        storageDTO.setCommodityCode(commodityCode);
        storageDTO.setCount(orderCount);
        storageFeignClient.reduce(storageDTO);
        Map<String, Object> result = new HashMap<>();
        result.put("code", "000000");
        result.put("msg", "success");
        return result;
    }

    public Map<String, Object> purchaseFail(PurchaseBusinessDTO purchaseBusinessDTO) {
        return null;
    }
}
