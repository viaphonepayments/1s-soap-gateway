package com.viaphone.soap;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class Application {

    private static Logger log = Logger.getLogger(Application.class);
    private static String APP_HOME = System.getProperty("user.dir");
    private static String APP_PROP = APP_HOME + File.separator + "app.properties";

    public static void main(String[] args) {
        try {
            log.info("Starting application...");
            Properties prop = new Properties();
            InputStream input = new FileInputStream(APP_PROP);
            prop.load(input);
            SpringApplication app = new SpringApplicationBuilder().sources(Application.class).properties(prop).build();
            app.addListeners(new ApplicationPidFileWriter("app.pid"));
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
