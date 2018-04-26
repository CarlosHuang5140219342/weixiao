package com.thesisdesign.weixiao.api.controller;

import com.thesisdesign.madlife.contract.service.TestService;
import com.thesisdesign.weixiao.common.request.ExtractRequest;
import com.thesisdesign.weixiao.common.result.ExtractResult;
import com.thesisdesign.weixiao.core.service.TextExtractionLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestConrtroller {
    @Autowired(required = false)
    private TestService testService;

    @Autowired
    private TextExtractionLocalService textExtractionLocalService;

    @RequestMapping("/hello")
    @ResponseBody
    public String getHello(){
        return "hello world!";
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public String getHello2(){
        return testService.getDubboCall();
    }

//    @RequestMapping("/j2p")
//    @ResponseBody
//    public String getJ2p(){
//        return testService.javaCallPython("/home/carloshuang/IdeaProjects/Demo.py");
//    }

    @RequestMapping("/j2p")
    @ResponseBody
    public ExtractResult getJ2p(){
        ExtractRequest request = new ExtractRequest();
        request.setFilename("/home/carloshuang/1.txt");
        return textExtractionLocalService.extractText(request);
    }
}
