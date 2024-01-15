package com.example.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;

public class Activator implements BundleActivator {


    public void start(BundleContext context) throws Exception {
        System.out.println("Hello OSGi World!");
        ServiceReference<HttpService> ref = context.getServiceReference(HttpService.class);
        HttpService httpService = context.getService(ref);
        HttpContext httpContext = httpService.createDefaultHttpContext();
        httpService.registerServlet("/hello", new HelloWorld(), null, httpContext);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye OSGi World!");
    }

}
