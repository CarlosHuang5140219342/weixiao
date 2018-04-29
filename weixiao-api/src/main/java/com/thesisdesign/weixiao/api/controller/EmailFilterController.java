package com.thesisdesign.weixiao.api.controller;

import com.thesisdesign.weixiao.common.request.EmailFilterRequest;
import com.thesisdesign.weixiao.common.result.EmailWithTagResult;
import com.thesisdesign.weixiao.core.service.EmailFilterLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/email")
public class EmailFilterController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmailFilterLocalService emailFilterLocalService;

    @RequestMapping(value = "/get_tag", method = RequestMethod.POST)
    @ResponseBody
    public EmailWithTagResult getEmailWithTagResult(@Valid @RequestBody EmailFilterRequest request){
        logger.info("get tag for emails by request : {}", request);
        return emailFilterLocalService.addTag(request);
    }
}
