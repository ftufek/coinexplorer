package org.coinexplorer.rest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.ReflectiveJaxrsScanner;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.reader.ClassReaders;


@WebServlet(name = "SwaggerJaxrsConfig", loadOnStartup = 1)
public class Swagger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
            ReflectiveJaxrsScanner scanner = new ReflectiveJaxrsScanner();
            scanner.setResourcePackage("org.coinexplorer");
            ScannerFactory.setScanner(scanner);
            ClassReaders.setReader(new DefaultJaxrsApiReader());
            
            SwaggerConfig swaggerConfig = new SwaggerConfig();
            ConfigFactory.setConfig(swaggerConfig);
            swaggerConfig.setBasePath("http://localhost:8080/coinexplorer/rest");
            swaggerConfig.setApiVersion("1.0.0");
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        }
    }
}