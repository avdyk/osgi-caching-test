package com.github.avdyk.osgi.caching.test.core;

import com.github.avdyk.osgi.caching.test.api.DeveloperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("com.github.avdyk.osgi.caching.testService")
public class OSGiDeveloperService implements DeveloperService {

    private static Logger logger = LoggerFactory.getLogger(OSGiDeveloperService.class);

    @Override
    public List<String> getDevelopers(String service) {
        logger.info("get developer for {}", service);
        return getDevs(service);
    }

    private List<String> getDevs(String service) {
        logger.info("Creating dev list for {}", service);
        final List<String> devs = new ArrayList<>();
        for (int i = 0 ; i < 10; i++) {
            devs.add("Dev " + (i + 1) + " service " + service);
        }
        return devs;
    }


}
