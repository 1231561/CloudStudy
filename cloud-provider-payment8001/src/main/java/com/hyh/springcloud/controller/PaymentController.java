package com.hyh.springcloud.controller;

import com.hyh.springcloud.PaymentService;
import com.hyh.springcloud.entities.CommonResult;
import com.hyh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService service;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int res = service.create(payment);
        if(res > 0){
            System.out.println(log);
            log.info("插入了"+res+"条数据");
            return new CommonResult<>(200, "插入成功",res);
        }else{
            return new CommonResult<>(40000,"插入失败");
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        Payment payment = service.getPaymentById(id);
        if(payment != null){
            return new CommonResult<>(200,"已查到数据",payment);
        }else{
            return new CommonResult<>(40001,"没有这条记录");
        }
    }
}
