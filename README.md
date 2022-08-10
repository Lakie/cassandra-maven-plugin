# MojoHaus Cassandra Maven Plugin

This is the [cassandra-maven-plugin](http://www.mojohaus.org/cassandra-maven-plugin/).
 
[//]: # ([![Maven Central]&#40;https://img.shields.io/maven-central/v/org.codehaus.mojo/cassandra-maven-plugin.svg?label=Maven%20Central&#41;]&#40;https://search.maven.org/artifact/org.codehaus.mojo/cassandra-maven-plugin&#41;)
[//]: # ([![Build Status]&#40;https://travis-ci.org/mojohaus/cassandra-maven-plugin.svg?branch=master&#41;]&#40;https://travis-ci.org/mojohaus/cassandra-maven-plugin&#41;)
NOTE:  latest version: 3.8-goto-SNAPSHOT based on forked plugin version 3.7
the main changes: addin possibility to start under JDK15, using cassandra 4.0.5
## Releasing

* Make sure `gpg-agent` is running.
* Execute `mvn -B release:prepare release:perform`

For publishing the site do the following:

```
cd target/checkout
mvn verify site site:stage scm-publish:publish-scm
```
