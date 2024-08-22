package com.dm.ecommerce.user_service.config;

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
        Locale.setDefault(Locale.ENGLISH);
        mSource.setDefaultLocale(new Locale(env.getProperty("spring.config.location")));
        messageSource =  mSource;
    }

    public static String get(String message){
        String locale = env.getProperty("spring.config.location");
        if(locale.equalsIgnoreCase("en") || locale.equalsIgnoreCase("us") || locale.equalsIgnoreCase("en_US")){
            locale = null;
        }

        return messageSource.getMessage(message, null,locale==null ? Locale.getDefault():new Locale(locale));
    }

}
