package com.thesisdesign.weixiao.core.service.impl;

import com.thesisdesign.madlife.contract.service.EmailFilterService;
import com.thesisdesign.madlife.contract.vo.EmailWithTagVO;
import com.thesisdesign.madlife.contract.vo.SingleEmailVO;
import com.thesisdesign.weixiao.common.request.EmailFilterRequest;
import com.thesisdesign.weixiao.common.result.EmailWithTagResult;
import com.thesisdesign.weixiao.core.service.EmailFilterLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EmailFilterLocalServiceImpl implements EmailFilterLocalService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private EmailFilterService emailFilterService;

    @Override
    public EmailWithTagResult addTag(EmailFilterRequest request) {
        EmailWithTagResult result = new EmailWithTagResult();
        if(CollectionUtils.isEmpty(request.getEmailWithContentVOList())){
            return result;
        }
        List<EmailWithTagVO> emailWithTagVOList = new ArrayList<>();
        emailWithTagVOList = emailFilterService.addTag(request.getEmailWithContentVOList());
        logger.info("dubbo call : email service , result : {}", emailWithTagVOList.toString());
        result.setEmailWithTagVOList(emailWithTagVOList);
        return result;
    }
}
