package com.lgl.practice.payment.controller;

import com.lgl.practice.common.enums.ResponseCodeEnum;
import com.lgl.practice.common.utils.ResponseData;
import com.lgl.practice.payment.entity.Payment;
import com.lgl.practice.payment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 15911
 * @Date 2023/4/17 21:44
 * @Version 1.0
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    /**
     * 1、@RestController：@Controller + @ResponseBody 。一个注解顶两个注解，以前就是写两个注解。@Controller 注解允许通过类路径扫描自动检测实现类。@ResponseBody 注解指示方法返回值的批注应绑定到 Web 响应正文。
     *
     * 2、@GetMapping：用于将 HTTP GET 请求映射到特定处理程序方法的注释。等价于 @RequestMapping(method = RequestMethod.GET)。
     *
     * 3、@PostMapping：用于将 HTTP POST 请求映射到特定处理程序方法的注释。等价于 @RequestMapping(method = RequestMethod.POST)。
     *
     * 4、@PathVariable：指示方法参数应绑定到 URI 模板变量的注释。请求地址中的参数变量需要用“{}”大括号括起来。
     *
     * 5、@RequestBody：指示方法参数的注释应绑定到 Web 请求的正文。请求的正文通过 以 HttpMessageConverter 解析方法参数，具体取决于请求的内容类型。或者，可以通过使用 对 @Valid 参数进行批注来应用自动验证。这个注解使用很灵活，也很常用，支持同时使用 @Validated 注解进行校验。方法入参支持实体类，支持 Map 类等等，主要在 POST 方式中使用较多，Get 方式也支持。
     *
     * 6、@Validated：JSR-303的 javax.validation.Valid的变体，支持验证组的规范。
     */

    @Autowired
    private IPaymentService paymentService;

    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/queryByOrderNum/{orderNum}")
    public ResponseData queryByOrderNum(@PathVariable String orderNum) {
        Payment payment = paymentService.getByOrderNum(orderNum);
        return payment == null ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), payment);
    }

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    @GetMapping("/queryById/{id}")
    public ResponseData queryById(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        return payment == null ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), payment);
    }

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    @PostMapping("/add")
    public ResponseData add(@RequestBody @Validated Payment payment) {
        int addResult = paymentService.add(payment);
        return addResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, "新增数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "新增数据失败");
    }

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/deleteByOrderNum/{orderNum}")
    public ResponseData deleteByOrderNum(@PathVariable String orderNum) {
        int deleteResult = paymentService.deleteByOrderNum(orderNum);
        return deleteResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, "删除数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "删除数据失败");
    }

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    @GetMapping("/deleteById/{id}")
    public ResponseData deleteById(@PathVariable Long id) {
        int deleteResult = paymentService.deleteById(id);
        return deleteResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, "删除数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "删除数据失败");
    }
}
