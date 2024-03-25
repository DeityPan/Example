package panbq.seata.feign;

import com.example.api.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient("account-service")
public interface AccountFeignClient {
    @PostMapping("/debit")
    public Map<String, Object> debit(@RequestBody AccountDTO accountDTO);
}
