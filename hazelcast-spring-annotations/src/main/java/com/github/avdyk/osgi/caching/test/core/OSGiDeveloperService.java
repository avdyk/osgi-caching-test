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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("osgiDeveloperService")
public class OSGiDeveloperService implements DeveloperService {

    private static final Logger logger = LoggerFactory.getLogger(OSGiDeveloperService.class);
    private static final String DEVELOPERS = "developers";

    @Override
    @Cacheable(DEVELOPERS)
    public List<String> getDevelopers(final String service) {
        logger.info("get developer for {}", service);

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
