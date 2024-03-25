package com.example.business.feign;

import com.example.api.StorageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient("storage-service")
public interface StorageFeignClient {
    @PostMapping("/reduce")
    public Map<String, String> reduce(@RequestBody StorageDTO storageDTO);
}
