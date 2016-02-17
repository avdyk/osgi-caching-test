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

# javax.cache

When starting the core bundle, I have a __No CachingProviders have
been configured__.

```java
2016-02-12 11:46:50,446 | ERROR | tenderThread-300 | ContextLoaderListener            | 107 - org.springframework.osgi.extender - 1.2.1 | Application context refresh failed (OsgiBundleXmlApplicationContext(bundle=com.github.avdyk.osgi.caching.test.com.github.avdyk.osgi.caching.test-core, config=osgibundle:/META-INF/spring/*.xml))
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'osgiDevelopperService': Invocation of init method failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.github.avdyk.osgi.caching.testService' defined in URL [bundleresource://837.fwk1395852929/com/github/avdyk/osgi/caching/test/core/OSGiDevelopperService.class]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Could not instantiate bean class [com.github.avdyk.osgi.caching.test.core.OSGiDevelopperService]: Constructor threw exception; nested exception is javax.cache.CacheException: No CachingProviders have been configured
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1514)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:521)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:458)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:293)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:223)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:290)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:191)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:618)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:934)[102:org.apache.servicemix.bundles.spring-context:3.2.11.RELEASE_1]
	at org.springframework.osgi.context.support.AbstractDelegatedExecutionApplicationContext.access$1600(AbstractDelegatedExecutionApplicationContext.java:69)[106:org.springframework.osgi.core:1.2.1]
	at org.springframework.osgi.context.support.AbstractDelegatedExecutionApplicationContext$4.run(AbstractDelegatedExecutionApplicationContext.java:355)[106:org.springframework.osgi.core:1.2.1]
	at org.springframework.osgi.util.internal.PrivilegedUtils.executeWithCustomTCCL(PrivilegedUtils.java:85)[106:org.springframework.osgi.core:1.2.1]
	at org.springframework.osgi.context.support.AbstractDelegatedExecutionApplicationContext.completeRefresh(AbstractDelegatedExecutionApplicationContext.java:320)[106:org.springframework.osgi.core:1.2.1]
	at org.springframework.osgi.extender.internal.dependencies.startup.DependencyWaiterApplicationContextExecutor$CompleteRefreshTask.run(DependencyWaiterApplicationContextExecutor.java:132)[107:org.springframework.osgi.extender:1.2.1]
	at java.lang.Thread.run(Thread.java:744)[:1.7.0_51]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.github.avdyk.osgi.caching.testService' defined in URL [bundleresource://837.fwk1395852929/com/github/avdyk/osgi/caching/test/core/OSGiDevelopperService.class]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Could not instantiate bean class [com.github.avdyk.osgi.caching.test.core.OSGiDevelopperService]: Constructor threw exception; nested exception is javax.cache.CacheException: No CachingProviders have been configured
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1039)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:985)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:487)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:458)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:293)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:223)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:290)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:191)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.osgi.service.exporter.support.OsgiServiceFactoryBean.afterPropertiesSet(OsgiServiceFactoryBean.java:167)[106:org.springframework.osgi.core:1.2.1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1573)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1511)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	... 14 more
Caused by: org.springframework.beans.BeanInstantiationException: Could not instantiate bean class [com.github.avdyk.osgi.caching.test.core.OSGiDevelopperService]: Constructor threw exception; nested exception is javax.cache.CacheException: No CachingProviders have been configured
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:163)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:87)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1032)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	... 24 more
Caused by: javax.cache.CacheException: No CachingProviders have been configured
	at javax.cache.Caching$CachingProviderRegistry.getCachingProvider(Caching.java:381)[634:javax.cache.api:1.0.0]
	at javax.cache.Caching$CachingProviderRegistry.getCachingProvider(Caching.java:351)[634:javax.cache.api:1.0.0]
	at javax.cache.Caching.getCachingProvider(Caching.java:142)
	at com.github.avdyk.osgi.caching.test.core.OSGiDevelopperService.<init>(OSGiDevelopperService.java:28)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)[:1.7.0_51]
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)[:1.7.0_51]
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)[:1.7.0_51]
	at java.lang.reflect.Constructor.newInstance(Constructor.java:526)[:1.7.0_51]
	at org.springframework.beans.BeanUtils.instantiateClass(BeanUtils.java:148)[100:org.apache.servicemix.bundles.spring-beans:3.2.11.RELEASE_1]
	... 26 more
```
