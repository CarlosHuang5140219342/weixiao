package com.thesisdesign.weixiao.api.controller;

import com.thesisdesign.madlife.contract.service.TestService;
import com.thesisdesign.madlife.contract.vo.EmailWithTagVO;
import com.thesisdesign.madlife.contract.vo.SingleEmailVO;
import com.thesisdesign.weixiao.common.request.EmailFilterRequest;
import com.thesisdesign.weixiao.common.request.ExtractRequest;
import com.thesisdesign.weixiao.common.result.ExtractResult;
import com.thesisdesign.weixiao.core.service.EmailFilterLocalService;
import com.thesisdesign.weixiao.core.service.FileGetService;
import com.thesisdesign.weixiao.core.service.TextExtractionLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestConrtroller {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private TestService testService;

    @Autowired
    private TextExtractionLocalService textExtractionLocalService;

    @Autowired
    private EmailFilterLocalService emailFilterLocalService;

    @Autowired
    private FileGetService fileGetService;

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

    @RequestMapping("/j2p")
    @ResponseBody
    public ExtractResult getJ2p(){
        String localFile = "/home/carloshuang/1.txt";
        logger.info("get info of local file : {}", localFile);
        ExtractRequest request = new ExtractRequest();
        request.setFilename(localFile);
        return textExtractionLocalService.extractText(request);
    }

    @RequestMapping("/add_tag")
    @ResponseBody
    public List<EmailWithTagVO> addTagTest(){
        logger.info("test add tag");
        List<SingleEmailVO> emailWithContentVOList = new ArrayList<>();
        emailWithContentVOList.add(new SingleEmailVO("id13","contentsadsda"));
        return emailFilterLocalService.addTag(new EmailFilterRequest(emailWithContentVOList)).getEmailWithTagVOList();
    }
}
