package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * @author Louis
 * @date Create in 2019/12/18 20:16
 */
public interface BuyerService {

    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
