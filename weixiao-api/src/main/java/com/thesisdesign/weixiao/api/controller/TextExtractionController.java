package com.thesisdesign.weixiao.api.controller;

import com.thesisdesign.weixiao.common.request.ExtractRequest;
import com.thesisdesign.weixiao.common.result.ExtractResult;
import com.thesisdesign.weixiao.core.service.TextExtractionLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/text")
public class TextExtractionController {
    @Autowired
    private TextExtractionLocalService textExtractionLocalService;

    @RequestMapping(value = "/extract", method = RequestMethod.POST)
    @ResponseBody
    public ExtractResult getExtractResult(@Valid @RequestBody ExtractRequest request){
        return textExtractionLocalService.extractText(request);
    }

    @RequestMapping("/extract_list")
    @ResponseBody
    public String getInfoList(){
        return null;
    }
}
