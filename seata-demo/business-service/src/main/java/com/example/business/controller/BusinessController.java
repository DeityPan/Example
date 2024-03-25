package com.example.business.controller;

import com.example.business.dto.PurchaseBusinessDTO;
import com.example.business.service.BusinessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/business")
public class BusinessController {
    @Resource
    private BusinessService businessService;
    @PostMapping("/purchase/success")
    public Map<String, Object> purchaseSuccess(@RequestBody PurchaseBusinessDTO purchaseBusinessDTO) {
        return businessService.purchaseSuccess(purchaseBusinessDTO);
    }
    @PostMapping("/purchase/fail")
    public Map<String, Object> purchaseFail(@RequestBody PurchaseBusinessDTO purchaseBusinessDTO) {
        return businessService.purchaseFail(purchaseBusinessDTO);
    }
}
