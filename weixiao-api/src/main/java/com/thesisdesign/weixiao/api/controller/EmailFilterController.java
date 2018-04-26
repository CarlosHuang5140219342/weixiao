package com.thesisdesign.weixiao.api.controller;

import com.thesisdesign.weixiao.common.request.EmailFilterRequest;
import com.thesisdesign.weixiao.common.result.EmailWithTagResult;
import com.thesisdesign.weixiao.core.service.EmailFilterLocalService;
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
    @Autowired
    private EmailFilterLocalService emailFilterLocalService;

    @RequestMapping(value = "/get_tag", method = RequestMethod.POST)
    @ResponseBody
    public EmailWithTagResult getExtractResult(@Valid @RequestBody EmailFilterRequest request){
        return emailFilterLocalService.addTag(request);
    }
}
