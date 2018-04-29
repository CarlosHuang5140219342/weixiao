package com.thesisdesign.weixiao.core.service.impl;

import com.thesisdesign.weixiao.common.utils.CommonUtils;
import com.thesisdesign.weixiao.core.service.FileGetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class FileGetServiceImpl implements FileGetService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String fileUpload(MultipartFile file) {
        if (file.isEmpty()) {
            return "empty file";
        }
        // get filename
        String fileName = file.getOriginalFilename();
        // get suffix
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // define store path
        String filePath = CommonUtils.FILE_STORE_PATH;
        File dest = new File(filePath + fileName);
        // check dir
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            logger.info("upload file : {}", filePath + fileName);
            return filePath + fileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath + fileName;
    }

    @Override
    public String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
}
