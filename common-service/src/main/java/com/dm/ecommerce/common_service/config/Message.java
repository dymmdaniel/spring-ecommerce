package com.dm.ecommerce.common_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Message {

    private static Environment env;
    private static MessageSource messageSource;

    @Autowired
    public Message(Environment environment) {
        env = environment;
        ReloadableResourceBundleMessageSource mSource = new ReloadableResourceBundleMessageSource();
        mSource.setBasename("classpath:messages/messages");
        mSource.setDefaultEncoding("UTF-8");
        messageSource =  mSource;
    }

    public static String get(String message){
        return messageSource.getMessage(message, null,new Locale(env.getProperty("spring.config.location")));
    }

}
