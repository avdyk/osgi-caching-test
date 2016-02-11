package com.github.avdyk.osgi.caching.test.core;

import com.github.avdyk.osgi.caching.test.api.DevelopperService;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("com.github.avdyk.osgi.caching.testService")
public class OSGiDevelopperService implements DevelopperService {

    private static Logger logger = LoggerFactory.getLogger(OSGiDevelopperService.class);
    private final HazelcastCacheManager cacheManager;

    @Inject
    public OSGiDevelopperService(HazelcastCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public List<String> getDeveloppers(String service) {
        logger.info("get developper for {}", service);
        final List<String> devs;
        final Cache cache = cacheManager.getCache("avdyk");
        if (cache != null) {
            final Cache.ValueWrapper valueWrapper = cache.get(service);
            if (valueWrapper != null) {
                final Object o = valueWrapper.get();
                if (o != null) {
                    logger.info("Value is in the cache");
                    devs = (List<String>) valueWrapper.get();
                } else {
                    logger.info("Value has been lost!");
                    devs = getDevs(service);
                    cache.put(service, devs);
                }
            } else {
                logger.warn("No value in the cache");
                devs = getDevs(service);
                cache.put(service, devs);
            }
        } else {
            logger.warn("Unable to get the cache!");
            devs = getDevs(service);
        }
        return devs;
    }

    private List<String> getDevs(String service) {
        logger.info("Creating dev list for {}", service);
        final List<String> devs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            devs.add("Dev " + (i + 1) + " service " + service);
        }
        return devs;
    }


}
