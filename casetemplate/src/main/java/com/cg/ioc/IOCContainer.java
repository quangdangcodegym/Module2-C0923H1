package com.cg.ioc;

import com.cg.service.IOrderDetailService;
import com.cg.service.IProductService;
import com.cg.service.IService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IOCContainer {
    public static IService getService(String propertieName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properites");
            // load a properties file
            prop.load(input);
            // get the database value
            String iProductService = prop.getProperty(propertieName);
            Class<?> tClass = Class.forName(iProductService);


            return (IService) tClass.newInstance();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

}
