package com.thesisdesign.weixiao.core.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileGetService {
    String fileUpload(MultipartFile file);
    String readToString(String fileName);
}
