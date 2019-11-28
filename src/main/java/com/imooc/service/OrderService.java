package com.imooc.service;

import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Louis
 * @date Create in 2019/11/4 21:57
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO 订单DTO
     * @return 订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     * @param orderId 订单id
     * @return OrderDTO
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     * @param buyerOpenid 买家openid
     * @param pageable page参数
     * @return OrderDTO
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 查询订单列表
     * @param pageable page参数
     * @return OrderDTO
     */

    Page<OrderDTO> findList(Pageable pageable);
    /**
     * 取消订单
     * @param orderDTO 订单DTO
     * @return OrderDTO
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     * @param orderDTO 订单DTO
     * @return OrderDTO
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     * @param orderDTO 订单DTO
     * @return OrderDTO
     */
    OrderDTO paid(OrderDTO orderDTO);
}
