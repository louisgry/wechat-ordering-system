package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Louis
 * @Date: Create in 2019/11/4 21:32
 * @Description:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 根据订单id查询订单详情
     * @param orderId 订单id
     * @return 订单详情列表
     */
    List<OrderDetail> findByOrderId(String orderId);
}
