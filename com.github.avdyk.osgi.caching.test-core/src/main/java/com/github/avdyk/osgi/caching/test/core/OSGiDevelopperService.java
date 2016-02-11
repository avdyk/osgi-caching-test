package com.github.avdyk.osgi.caching.test.core;

import com.github.avdyk.osgi.caching.test.api.DevelopperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("com.github.avdyk.osgi.caching.testService")
public class OSGiDevelopperService implements DevelopperService {

    private static Logger logger = LoggerFactory.getLogger(OSGiDevelopperService.class);

    @Override
    public List<String> getDeveloppers(String service) {
        logger.info("get developper for {}", service);
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
