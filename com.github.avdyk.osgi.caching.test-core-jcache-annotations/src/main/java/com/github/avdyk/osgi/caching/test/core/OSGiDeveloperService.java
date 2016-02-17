package com.github.avdyk.osgi.caching.test.core;

import com.github.avdyk.osgi.caching.test.api.DeveloperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("com.github.avdyk.osgi.caching.testService")
public class OSGiDeveloperService implements DeveloperService {

    private static Logger logger = LoggerFactory.getLogger(OSGiDeveloperService.class);

    private static final String CACHE_NAME = "avdyk_cache";
    private final CacheManager cacheManager;

    public OSGiDeveloperService() {
        logger.info("Configuring the cache");
        CachingProvider cachingProvider = Caching.getCachingProvider();
        cacheManager = cachingProvider.getCacheManager();
        MutableConfiguration<String, List> config = new MutableConfiguration();
        config.setStoreByValue(true)
            .setTypes(String.class, List.class)
            .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.FIVE_MINUTES))
            .setStatisticsEnabled(false);
        cacheManager.createCache(CACHE_NAME, config);
    }

    @Override
    public List<String> getDevelopers(String service) {
        logger.info("get developer for {}", service);
        Cache<String, List> cache = cacheManager.getCache(CACHE_NAME, String.class, List.class);
        final List<String> devs;
        if (cache.containsKey(service)) {
            devs = cache.get(service);
        } else {
            devs = getDevs(service);
            cache.put(service, devs);
        }
        return devs;
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
