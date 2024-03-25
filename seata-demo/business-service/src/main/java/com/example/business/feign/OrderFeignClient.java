package com.example.business.feign;

import com.example.api.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient("order-service")
public interface OrderFeignClient {
    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody OrderDTO orderDTO);
}
