package com.thesisdesign.weixiao.common.result;

import com.thesisdesign.madlife.contract.vo.EmailWithTagVO;

import java.io.Serializable;
import java.util.List;

public class EmailWithTagResult implements Serializable {
    List<EmailWithTagVO> emailWithTagVOList;

    public EmailWithTagResult() {
    }

    public EmailWithTagResult(List<EmailWithTagVO> emailWithTagVOList) {
        this.emailWithTagVOList = emailWithTagVOList;
    }

    public List<EmailWithTagVO> getEmailWithTagVOList() {
        return emailWithTagVOList;
    }

    public void setEmailWithTagVOList(List<EmailWithTagVO> emailWithTagVOList) {
        this.emailWithTagVOList = emailWithTagVOList;
    }
}
