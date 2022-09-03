package me.hardy.springcircularreference.controller;

import me.hardy.springcircularreference.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String test() {
        orderService.order();

        return "OK";
    }
}
