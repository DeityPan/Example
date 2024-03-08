package com.example.storage.controller;

import com.example.storage.dto.StorageDTO;
import com.example.storage.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("storage")
public class StorageController {
    @Resource
    private StorageService storageService;
    @PostMapping("/reduce")
    public Map<String, Object> reduce(@RequestBody StorageDTO storageDTO) {
        return storageService.reduce(storageDTO);
    }

}
