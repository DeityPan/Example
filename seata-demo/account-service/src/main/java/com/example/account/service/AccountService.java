package com.example.account.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.account.dto.AccountDTO;
import com.example.account.mapper.AccountMapper;
import com.example.account.model.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    public Map<String, Object> debit(AccountDTO accountDTO) {
        String userId = accountDTO.getUserId();
        UpdateWrapper<Account> uw = new UpdateWrapper<>();
        uw.eq("user_id", userId);

        Account realAccount = accountMapper.selectOne(uw);
        Account account = new Account();
        account.setMoney(realAccount.getMoney() - accountDTO.getMoney());

        accountMapper.update(account, uw);
        Map<String, Object> result = new HashMap<>();
        result.put("code", "000000");
        result.put("msg", "success");
        return result;
    }
}
