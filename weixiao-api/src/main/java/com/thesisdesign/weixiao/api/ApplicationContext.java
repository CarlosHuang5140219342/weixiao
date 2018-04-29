package com.thesisdesign.weixiao.api;

import com.thesisdesign.weixiao.common.utils.CommonUtils;
import com.thesisdesign.weixiao.core.WeixiaoCoreContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {
        WeixiaoCoreContext.class
})
public class ApplicationContext implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationContext.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(CommonUtils.WEIXIAO_PROJ_PORT);
    }


}
