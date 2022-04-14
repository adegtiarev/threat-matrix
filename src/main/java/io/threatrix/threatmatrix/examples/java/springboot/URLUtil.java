/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://spring.io/projects/spring-boot
*    Release: https://github.com/spring-projects/spring-boot/releases/tag/v3.0.0-M1
*    Source File: SpringCli.java
*    
*    Copyrights:
*      copyright 2012-2018 the original author or authors
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
package io.threatrix.threatmatrix.utility.springboot;

import org.springframework.util.SystemPropertyUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLUtil {

    private URL[] getExtURLs() {
        List<URL> urls = new ArrayList<>();
        String home = SystemPropertyUtils.resolvePlaceholders("${spring.home:${SPRING_HOME:.}}");
        File extDirectory = new File(new File(home, "lib"), "ext");
        if (extDirectory.isDirectory()) {
            for (File file : extDirectory.listFiles()) {
                if (file.getName().endsWith(".jar")) {
                    try {
                        urls.add(file.toURI().toURL());
                    }
                    catch (MalformedURLException ex) {
                        throw new IllegalStateException(ex);
                    }
                }
            }
        }
        return urls.toArray(new URL[0]);
    }
}
