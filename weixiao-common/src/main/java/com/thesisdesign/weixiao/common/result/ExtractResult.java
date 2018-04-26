package com.thesisdesign.weixiao.common.result;

import com.thesisdesign.weixiao.common.vo.SingleInfoVO;

import java.io.Serializable;
import java.util.List;

public class ExtractResult implements Serializable {
    List<SingleInfoVO> infoVOList;

    public List<SingleInfoVO> getInfoVOList() {
        return infoVOList;
    }

    public void setInfoVOList(List<SingleInfoVO> infoVOList) {
        this.infoVOList = infoVOList;
    }
}
