package com.imooc.dto;

import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Louis
 * @date Create in 2019/11/5 18:40
 */
@Data
public class OrderDTO {

    /** 订单id */
    private String orderId;

    /** 买家姓名 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态，默认为新下单NEW */
    private Integer orderStatus;

    /** 支付状态，默认为未支付0 */
    private Integer payStatus;

    /** 订单详情列表 */
    List<OrderDetail> orderDetailList;
}
