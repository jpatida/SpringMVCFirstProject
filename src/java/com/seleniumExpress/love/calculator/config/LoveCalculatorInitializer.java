package com.seleniumExpress.love.calculator.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("onStartup() method of WebApplicationInitializer>>>>>>>>>>>>>>> ");

		/*
		 * XmlWebApplicationContext webContext = new XmlWebApplicationContext();
		 * webContext.setConfigLocation("classpath:application-config.xml");
		 */
		
		AnnotationConfigApplicationContext webApplicationContext = new AnnotationConfigApplicationContext();
		webApplicationContext.register(ApplicationConfig.class);
		// Create Dispatcher Servlet object

		//DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
		DispatcherServlet dispatcherServlet = new DispatcherServlet((WebApplicationContext) webApplicationContext);

		// Register the Dispatcher servlet with ServletContext object
		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet",
				dispatcherServlet);
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/myWebsite.com/*");
		
	}

}
