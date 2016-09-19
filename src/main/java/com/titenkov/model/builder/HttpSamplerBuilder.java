package com.titenkov.model.builder;

import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.testelement.TestElement;

/**
 * Created by titenkov on 9/18/16.
 */
public class HttpSamplerBuilder {

    public HTTPSamplerProxy createTestSampler() {
        HTTPSamplerProxy titenkovSampler = new HTTPSamplerProxy();
        titenkovSampler.setDomain("titenkov.com");
        titenkovSampler.setPort(80);
        titenkovSampler.setPath("/");
        titenkovSampler.setMethod("GET");
        titenkovSampler.setName("Open titenkov.com");
        titenkovSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        titenkovSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
        return titenkovSampler;
    }

}
