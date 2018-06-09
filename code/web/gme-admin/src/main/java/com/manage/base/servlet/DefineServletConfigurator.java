package com.manage.base.servlet;

import java.io.File;
import java.util.Enumeration;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

/**
 * proxool加载
 *
 */
public class DefineServletConfigurator implements ServletContextListener{

    private static final Log LOG = LogFactory.getLog(DefineServletConfigurator.class);
    protected static final String PREFIX = "jdbc";
    private static final String XML_FILE_PROPERTY = "xmlFile";

    private static final String PROPERTY_FILE_PROPERTY = "propertyFile";

    private static final String AUTO_SHUTDOWN_PROPERTY = "autoShutdown";

    private boolean autoShutdown = true;


	public void contextDestroyed(ServletContextEvent arg0) {
		if (autoShutdown) {
            ProxoolFacade.shutdown(0);
        }
	}

	public void contextInitialized(ServletContextEvent servletConfig) {
		String appDir = servletConfig.getServletContext().getRealPath("/");
        Enumeration names = servletConfig.getServletContext().getInitParameterNames();
        Properties properties = new Properties();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String value = servletConfig.getServletContext().getInitParameter(name);

            if (name.equals(XML_FILE_PROPERTY)) {
                try {
                    File file = new File(value);
                    if (file.isAbsolute()) {
                        JAXPConfigurator.configure(value, false);
                    } else {
                    	String[]values=value.split(",");
                    	for (String string : values) {
                    		JAXPConfigurator.configure(appDir + File.separator + string, false);
						}
                    }
                } catch (ProxoolException e) {
                    LOG.error("Problem configuring " + value, e);
                }
            } else if (name.equals(PROPERTY_FILE_PROPERTY)) {
                try {
                    File file = new File(value);
                    if (file.isAbsolute()) {
                        PropertyConfigurator.configure(value);
                    } else {
                        PropertyConfigurator.configure(appDir + File.separator + value);
                    }
                } catch (ProxoolException e) {
                    LOG.error("Problem configuring " + value, e);
                }
            } else if (name.equals(AUTO_SHUTDOWN_PROPERTY)) {
                autoShutdown = Boolean.valueOf(value).booleanValue();
            } else if (name.startsWith(PREFIX)) {
                properties.setProperty(name, value);
            }
        }

        if (properties.size() > 0) {
            try {
                PropertyConfigurator.configure(properties);
            } catch (ProxoolException e) {
                LOG.error("Problem configuring using init properties", e);
            }
        }
	}
}