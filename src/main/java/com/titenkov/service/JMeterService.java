package com.titenkov.service;

import com.titenkov.model.Result;
import com.titenkov.model.builder.HttpSamplerBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.util.JMeterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by titenkov on 9/18/16.
 */
@Service
@Data
@Slf4j
public abstract class JMeterService {

    protected File JMETER_HOME = new File("/Users/titenkov/Projects/apache-jmeter-3.0");
    protected String SLASH = System.getProperty("file.separator");

    protected StandardJMeterEngine jmeter = new StandardJMeterEngine();
    protected HttpSamplerBuilder samplerBuilder = new HttpSamplerBuilder();


    protected void init() throws FileNotFoundException {
        if (!JMETER_HOME.exists()) {
            throw new FileNotFoundException("JMETER_HOME is not found");
        }

        File jmeterProperties = new File(JMETER_HOME.getPath() + SLASH + "bin" + SLASH + "jmeter.properties");

        if (!jmeterProperties.exists()) {
            throw new FileNotFoundException("JMeter properties haven't been found");
        }

        //JMeter initialization (properties, log levels, locale, etc)
        JMeterUtils.setJMeterHome(JMETER_HOME.getPath());
        JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
        JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();
    }

    abstract public Result run();

}
