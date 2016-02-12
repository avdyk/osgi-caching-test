# osgi-caching-test
Caching tests in OSGi.

The __master__ is where the __no cache__ is defined.

There are two examples of the cache implementation:

* [hazelcast-spring](https://github.com/avdyk/osgi-caching-test/tree/hazelcast-spring)
* [javax.cache](https://github.com/avdyk/osgi-caching-test/tree/javax.cache)

# master

Master contains the api, the service, the command and the feature. The
command has no cache implemented. It's just a starting point for the
example.
