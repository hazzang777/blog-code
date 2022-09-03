package me.devhardy.jpabulkinsert.controller;

import lombok.RequiredArgsConstructor;
import me.devhardy.jpabulkinsert.service.DummyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BulkController {

    private final DummyService dummyService;

    @PostMapping("/mysql")
    public String createDummiesInMysql() {
        long startTime = System.currentTimeMillis();
        dummyService.createDummies();
        System.out.println("걸리는 시간 : " + (System.currentTimeMillis() - startTime));
        return "ok";
    }

    @PostMapping("/oracle")
    public String createDummiesInOracle() {
        return "ok";
    }

}
