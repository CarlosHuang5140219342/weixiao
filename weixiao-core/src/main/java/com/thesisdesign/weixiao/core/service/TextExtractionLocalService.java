package com.thesisdesign.weixiao.core.service;

import com.thesisdesign.weixiao.common.request.ExtractRequest;
import com.thesisdesign.weixiao.common.result.ExtractResult;

public interface TextExtractionLocalService {
    ExtractResult extractText(ExtractRequest request);
}
