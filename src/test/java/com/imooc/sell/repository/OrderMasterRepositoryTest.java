package com.imooc.sell.repository;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Louis
 * @date Create in 2019/11/4 21:36
 */
@Component
public class OrderMasterRepositoryTest extends SellApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("Louis");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("China");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.3));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        String openid = "110110";
        PageRequest pageRequest = new PageRequest(0, 1);
        Page<OrderMaster> page = orderMasterRepository.findByBuyerOpenid(openid, pageRequest);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
        Assert.assertNotEquals(0, page.getTotalElements());
    }
}