package com.viaphone.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

class ShutdownManager{

    @Autowired
    private ApplicationContext appContext;

    public void initiateShutdown(int returnCode){
        SpringApplication.exit(appContext, () -> returnCode);
    }
}