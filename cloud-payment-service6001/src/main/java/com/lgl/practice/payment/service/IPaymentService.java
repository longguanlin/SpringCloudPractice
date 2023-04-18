package com.lgl.practice.payment.service;

import com.lgl.practice.payment.entity.Payment;

/**
 * Service接口
 * @Author 15911
 * @Date 2023/4/17 21:33
 * @Version 1.0
 */
public interface IPaymentService {
    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    Payment getByOrderNum(String orderNum);

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    Payment getById(Long id);

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    int add(Payment payment);

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    int deleteByOrderNum(String orderNum);

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    int deleteById(Long id);
}
