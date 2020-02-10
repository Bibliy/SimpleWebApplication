package com.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext  context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class,WebConfig.class);//в контейнер ложим класс бинов и класс какой путь
        context.setServletContext(servletContext);          //а также сервлет который приходит в метод onStartUP
       //создаем диспетчер сервлет
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");//пусть диспатсер обрабатывает сначала
    }
}
