# osgi-caching-test
Caching tests in OSGi.

The __-core__ is where the __no cache__ is defined. The cache tests
are in other __-core-*__ bundle

There are two examples of the cache implementation:

* core-hazelcast-spring
* core-javax.cache

# master

Master contains the api, the service, the command and the feature. The
command has no cache implemented. It's just a starting point for the
example.


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
