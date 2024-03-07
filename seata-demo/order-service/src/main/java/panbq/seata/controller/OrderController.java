package panbq.seata.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panbq.seata.dto.OrderDTO;
import panbq.seata.service.OrderService;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @PostMapping("/place")
    public Map<String, Object> placeOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.placeOrder(orderDTO);
    }
}
