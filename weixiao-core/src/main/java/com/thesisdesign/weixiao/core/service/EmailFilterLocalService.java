package com.thesisdesign.weixiao.core.service;

import com.thesisdesign.weixiao.common.request.EmailFilterRequest;
import com.thesisdesign.weixiao.common.result.EmailWithTagResult;

public interface EmailFilterLocalService {
    EmailWithTagResult addTag(EmailFilterRequest request);
}
