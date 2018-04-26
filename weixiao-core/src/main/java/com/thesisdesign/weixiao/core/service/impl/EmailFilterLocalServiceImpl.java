package com.thesisdesign.weixiao.core.service.impl;

import com.thesisdesign.madlife.contract.service.EmailFilterService;
import com.thesisdesign.madlife.contract.vo.EmailWithTagVO;
import com.thesisdesign.madlife.contract.vo.SingleEmailVO;
import com.thesisdesign.weixiao.common.request.EmailFilterRequest;
import com.thesisdesign.weixiao.common.result.EmailWithTagResult;
import com.thesisdesign.weixiao.core.service.EmailFilterLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class EmailFilterLocalServiceImpl implements EmailFilterLocalService {
    @Autowired(required = false)
    private EmailFilterService emailFilterService;

    @Override
    public EmailWithTagResult addTag(EmailFilterRequest request) {
        EmailWithTagResult result = new EmailWithTagResult();
        if(CollectionUtils.isEmpty(request.getEmailWithContentVOList())){
            return result;
        }
        List<EmailWithTagVO> emailWithTagVOList = new ArrayList<>();

        //emailWithTagVOList = emailFilterService.addTag(request.getEmailWithContentVOList());
        List<SingleEmailVO> emailWithContentVOList = request.getEmailWithContentVOList();
        for (SingleEmailVO vo : emailWithContentVOList) {
            EmailWithTagVO emailWithTagVO = new EmailWithTagVO();
            emailWithTagVO.setId(vo.getId());
            emailWithTagVO.setTag("0");
            emailWithTagVOList.add(emailWithTagVO);
        }

        result.setEmailWithTagVOList(emailWithTagVOList);
        return result;
    }
}
