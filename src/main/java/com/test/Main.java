package com.test;

import com.test.configuration.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Евгений on 17.03.2016.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        ActionSlpService actionSlpService = context.getBean(ActionSlpService.class);
        System.out.println("args = [" + args + "]");
    }
}
