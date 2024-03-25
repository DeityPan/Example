package panbq.seata.controller;

import com.example.api.OrderDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panbq.seata.service.OrderService;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @PostMapping("/place")
    public Map<String, Object> place(@RequestBody OrderDTO orderDTO) {
        return orderService.placeOrder(orderDTO);
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }


}
