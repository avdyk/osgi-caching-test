package com.github.avdyk.osgi.caching.test.core;

import com.github.avdyk.osgi.caching.test.api.DeveloperService;
import com.google.common.base.Function;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("osgiDeveloperService")
public class OSGiDeveloperService implements DeveloperService {

    private static final Logger logger = LoggerFactory.getLogger(OSGiDeveloperService.class);
    private static final String DEVELOPERS = "developers";

    private final CacheManager cacheManager;
    private final Cache cache;

    @Autowired
    public OSGiDeveloperService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
        cache = cacheManager.getCache(DEVELOPERS);
    }

    @Override
    public List<String> getDevelopers(final String service) {
        logger.info("get developer for {}", service);

        final Cache.ValueWrapper value = cache.get(service);
        if (value == null) {
            final List<String> list = createList(service);
            cache.put(service, list);

            return list;
        }

        return (List<String>) value.get();
    }

    public List<String> createList(final String service) {
        logger.warn("create list for service {}", service);

        return
            Lists.newArrayList(
                Iterables.transform(
                    ContiguousSet.create(
                        Range.closed(1, 10),
                        DiscreteDomain.integers()),
                    new Function<Integer, String>() {
                        @Override
                        public String apply(Integer integer) {
                            return "developer" + integer + "@" + service;
                        }
                    }));
    }
}
