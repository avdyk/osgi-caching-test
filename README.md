# osgi-caching-test
Caching tests in OSGi.

The __master__ is where the __no cache__ is defined.

There are two examples of the cache implementation:

* [hazelcast-spring](https://github.com/avdyk/osgi-caching-test/tree/hazelcast-spring)
* [javax.cache](https://github.com/avdyk/osgi-caching-test/tree/javax.cache)

# hazelcast-spring

Possibile configuration of hazelcast with a cache called _avdyk_:

```xml
    <map name="avdyk">
        <backup-count>0</backup-count>
        <async-backup-count>0</async-backup-count>
        <time-to-live-seconds>5</time-to-live-seconds>
        <max-idle-seconds>0</max-idle-seconds>
    </map>

```
