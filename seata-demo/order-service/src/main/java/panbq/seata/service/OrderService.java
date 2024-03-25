package panbq.seata.service;

import com.example.api.AccountDTO;
import com.example.api.OrderDTO;
import org.springframework.stereotype.Service;
import panbq.seata.feign.AccountFeignClient;
import panbq.seata.mapper.OrderMapper;
import panbq.seata.model.Order;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    private static final Map<String, Integer> commodityCodeMapPrice = new HashMap<>();
    static {
        commodityCodeMapPrice.put("100001", 10);
        commodityCodeMapPrice.put("100002", 20);
        commodityCodeMapPrice.put("100003", 30);
        commodityCodeMapPrice.put("100004", 40);
    }
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountFeignClient accountFeignClient;

    public Map<String, Object> placeOrder(OrderDTO orderDTO) {
        Map<String, Object> result = new HashMap<>();
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setCommodityCode(orderDTO.getCommodityCode());
        order.setCount(orderDTO.getCount());
        order.setMoney(commodityCodeMapPrice.get(orderDTO.getCommodityCode()) * orderDTO.getCount());
        System.out.println("新增订单详情:" + order);
        orderMapper.insert(order);
        result.put("code", "000000");
        result.put("msg", "success");
        return result;
    }

    public Map<String, Object> create(OrderDTO orderDTO) {
        String commodityCode = orderDTO.getCommodityCode();
        Integer price = commodityCodeMapPrice.get(commodityCode);
        Integer money = (new BigDecimal(price).multiply(new BigDecimal(orderDTO.getCount()))).intValue();

        Map<String, Object> result = new HashMap<>();
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setCommodityCode(orderDTO.getCommodityCode());
        order.setCount(orderDTO.getCount());
        order.setMoney(money);
        System.err.println("新增订单详情:" + order);
        orderMapper.insert(order);
        System.err.println("新增订单成功");

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(order.getUserId());
        accountDTO.setMoney(money);
        accountFeignClient.debit(accountDTO);
        result.put("code", "000000");
        result.put("msg", "success");
        return result;
    }

}
