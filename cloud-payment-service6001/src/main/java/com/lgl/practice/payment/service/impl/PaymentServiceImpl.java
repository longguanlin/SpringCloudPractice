package com.lgl.practice.payment.service.impl;

import com.lgl.practice.payment.dao.PaymentDao;
import com.lgl.practice.payment.entity.Payment;
import com.lgl.practice.payment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author 15911
 * @Date 2023/4/17 21:38
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    /**
     * 写法一：Spring的注解。将对象交由Spring去管理，官方不推荐这种写法。
     */
    //@Autowired
    //private PaymentDao paymentDao;

    private PaymentDao paymentDao;
    /**
     * 写法二：Spring的注解。Setter方式注入对象，官方推荐这种写法。
     * @param paymentDao
     */
    @Autowired
    public void setPaymentDao(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    /**
     * 写法三：Java的注解。全称javax.annotation.Resource,它属于JSR-250规范的一个注解，包含Jakarta EE（J2EE）中。
     */
    //@Resource
    //private PaymentDao paymentDao;

    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    @Override
    public Payment getByOrderNum(String orderNum) {
        return paymentDao.getByOrderNum(orderNum);
    }

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    @Override
    public int add(Payment payment) {
        Date currentTime = new Date();
        payment.setCreateTime(currentTime);
        payment.setUpdateTime(currentTime);
        return paymentDao.add(payment);
    }

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    @Override
    public int deleteByOrderNum(String orderNum) {
        return paymentDao.deleteByOrderNum(orderNum);
    }

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    @Override
    public int deleteById(Long id) {
        return paymentDao.deleteById(id);
    }
}
