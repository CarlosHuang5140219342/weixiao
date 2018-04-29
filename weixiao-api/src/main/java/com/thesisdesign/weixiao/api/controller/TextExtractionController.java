package com.thesisdesign.weixiao.api.controller;

import com.thesisdesign.weixiao.common.request.ExtractRequest;
import com.thesisdesign.weixiao.common.result.ExtractResult;
import com.thesisdesign.weixiao.core.service.FileGetService;
import com.thesisdesign.weixiao.core.service.TextExtractionLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/text")
public class TextExtractionController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TextExtractionLocalService textExtractionLocalService;

    @Autowired
    private FileGetService fileGetService;

    /*
       extract local file ,with request:{filename = xxxxx}
     */
    @RequestMapping(value = "/extract_local", method = RequestMethod.POST)
    @ResponseBody
    public ExtractResult getLocalExtractResult(@Valid @RequestBody ExtractRequest request){
        logger.info("get info of local file by request : {}", request);
        return textExtractionLocalService.extractText(request);
    }

    /*
       extract file ,with uploaded file : MultipartFile file
     */
    @RequestMapping(value = "/extract", method = RequestMethod.POST)
    @ResponseBody
    public ExtractResult getExtractResult(@RequestParam("file") MultipartFile file){
        logger.info("get info of file uploaded by MultipartFile : {}", file.getOriginalFilename());
        String localFileName = fileGetService.fileUpload(file);
        return textExtractionLocalService.extractText(new ExtractRequest(localFileName));
    }
}
