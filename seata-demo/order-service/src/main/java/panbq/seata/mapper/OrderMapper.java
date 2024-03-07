package panbq.seata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import panbq.seata.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
