package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Louis
 * @date Create in 2019/11/4 21:32
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 根据订单id查询订单详情
     * @param orderId 订单id
     * @return 订单详情列表
     */
    List<OrderDetail> findByOrderId(String orderId);
}
