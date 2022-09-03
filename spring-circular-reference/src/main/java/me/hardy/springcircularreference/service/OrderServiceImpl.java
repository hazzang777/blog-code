package me.hardy.springcircularreference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private PayService payService;

    @Override
    public void order() {
        payService.pay();
    }
}
