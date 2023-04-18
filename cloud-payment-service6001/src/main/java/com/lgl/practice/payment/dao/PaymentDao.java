package com.lgl.practice.payment.dao;

import com.lgl.practice.payment.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 15911
 * @Date 2023/4/17 21:36
 * @Version 1.0
 */
public interface PaymentDao {
    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    Payment getByOrderNum(@Param("orderNum") String orderNum);

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    Payment getById(@Param("id") Long id);

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    int add(@Param("payment") Payment payment);

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    int deleteByOrderNum(@Param("orderNum") String orderNum);

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    int deleteById(@Param("id") Long id);
}
