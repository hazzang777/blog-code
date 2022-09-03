package me.hardy.springcircularreference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService{

    @Autowired
    private OrderService orderService;

    @Override
    public void pay() {
        orderService.order();
    }
}
