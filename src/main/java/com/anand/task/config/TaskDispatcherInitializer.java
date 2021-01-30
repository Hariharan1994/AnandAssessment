package com.anand.task.config;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.anand.task.constants.SettingCons;
import com.anand.task.log.ConsoleLog;

/**
 * TaskDispatcherInitializer is used to initialize TaskWebSecurityConfig class.
 * Log file configuration is also initialized in this class.
 * 
 * @author ANAND MUTHUKUMAR
 * @since 23-01-2021
 */
public class TaskDispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	static {
		System.setProperty("Task.LogDatePattern", SettingCons.LOG_DATE_PATTERN);
		System.setProperty("Task.LogFolderPath", SettingCons.LOG_FOLDER_PATH);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { TaskWebSecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {}; // FswWebMvcConfig class is already configured @EnableMvc annotation
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		PropertyConfigurator.configure(SettingCons.LOG_PROPERTY_PATH); // Initialize log4j

		ConsoleLog.printLogMessage("@ 01 - Log property file configured in TaskDispatcherInitializer");

		final DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(
				servletAppContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return dispatcherServlet;
	}
}