package com.thesisdesign.weixiao.common.request;

import com.thesisdesign.madlife.contract.vo.SingleEmailVO;

import java.util.List;

public class EmailFilterRequest {
    List<SingleEmailVO> emailWithContentVOList;

    public EmailFilterRequest() {
    }

    public EmailFilterRequest(List<SingleEmailVO> emailWithContentVOList) {
        this.emailWithContentVOList = emailWithContentVOList;
    }

    public List<SingleEmailVO> getEmailWithContentVOList() {
        return emailWithContentVOList;
    }

    public void setEmailWithContentVOList(List<SingleEmailVO> emailWithContentVOList) {
        this.emailWithContentVOList = emailWithContentVOList;
    }
}
