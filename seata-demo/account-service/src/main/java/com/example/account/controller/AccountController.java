package com.example.account.controller;

import com.example.account.service.AccountService;
import com.example.api.AccountDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("account")
public class AccountController {
    @Resource
    private AccountService accountService;
    @PostMapping("/debit")
    public Map<String, Object> debit(@RequestBody AccountDTO accountDTO) {
        return accountService.debit(accountDTO);
    }
}
