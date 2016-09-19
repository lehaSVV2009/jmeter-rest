package com.titenkov.controller;

import com.titenkov.model.Result;
import com.titenkov.service.JMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by titenkov on 9/18/16.
 */
@RestController
public class JMeterController {

    @Autowired
    @Qualifier("JMeterServiceImpl")
    private JMeterService service;

    @RequestMapping("/test")
    public Result test() {
        return service.run();
    }

}