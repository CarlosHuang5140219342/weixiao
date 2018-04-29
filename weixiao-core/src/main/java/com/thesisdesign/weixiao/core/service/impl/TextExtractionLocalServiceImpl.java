package com.thesisdesign.weixiao.core.service.impl;

import com.thesisdesign.madlife.contract.request.TextExtractionRequest;
import com.thesisdesign.madlife.contract.result.TextExtractionResult;
import com.thesisdesign.madlife.contract.service.TextExtractionService;
import com.thesisdesign.madlife.contract.vo.ExtractInfoVO;
import com.thesisdesign.weixiao.common.enums.InfoTypeEnum;
import com.thesisdesign.weixiao.common.request.ExtractRequest;
import com.thesisdesign.weixiao.common.result.ExtractResult;
import com.thesisdesign.weixiao.common.vo.SingleInfoVO;
import com.thesisdesign.weixiao.core.service.FileGetService;
import com.thesisdesign.weixiao.core.service.TextExtractionLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TextExtractionLocalServiceImpl implements TextExtractionLocalService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private TextExtractionService textExtractionService;

    @Autowired
    private FileGetService fileGetService;

    @Override
    public ExtractResult extractText(ExtractRequest request) {
        //get file content
        String filename = request.getFilename();
        String content = fileGetService.readToString(filename);
        logger.info("get file : {}", filename);
        logger.info("file content : {}", content);
        //dubbo call
        TextExtractionRequest textExtractionRequest = new TextExtractionRequest();
        textExtractionRequest.setFilename(filename);
        textExtractionRequest.setContent(content);
        TextExtractionResult textExtractionResult = textExtractionService.getTextInformation(textExtractionRequest);

        return buildExtractResult(textExtractionResult);
    }

    private ExtractResult buildExtractResult(TextExtractionResult textExtractionResult){
        ExtractResult result = new ExtractResult();
        Map<Integer, SingleInfoVO> singleInfoVOMap = new HashMap<>();
        for (ExtractInfoVO vo : textExtractionResult.getExtractInfoVOList()){
            InfoTypeEnum type = InfoTypeEnum.getEnumTypeByTypeName(vo.getType());
            if(!Objects.equals(InfoTypeEnum.UNDEFINED, type)) {
                SingleInfoVO singleInfoVO = new SingleInfoVO();
                singleInfoVO.setId(type.getCode());
                singleInfoVO.setType(vo.getType());
                if(vo.getContent() != null && !vo.getContent().isEmpty()) {
                    singleInfoVO.setSize(vo.getContent().split(",").length);
                } else {
                    singleInfoVO.setSize(0);
                }
                singleInfoVO.setContent(vo.getContent());
                singleInfoVOMap.put(singleInfoVO.getId(), singleInfoVO);
            }
        }
        result.setInfoVOList(new ArrayList<>(singleInfoVOMap.values()));
        return result;
    }
}
