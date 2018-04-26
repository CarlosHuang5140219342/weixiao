package com.thesisdesign.weixiao.core;

import com.thesisdesign.weixiao.common.WeixiaoCommonContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(value = "com.thesisdesign.weixiao.core")
@Import(value = {
        WeixiaoCommonContext.class
})
public class WeixiaoCoreContext {
}
