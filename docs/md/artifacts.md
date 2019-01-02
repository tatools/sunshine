# Artifacts

Sunshine consists of 3 libraries
- `sunshine-core` provides interfaces and common implementations
- `sunshine-junit4` wraps JUnit4 to allow the creation of [entry points](entry-points.md)
- `sunshine-testng` wraps TestNG to allow the creation of [entry points](entry-points.md)

Artifact|`sunshine-testng`|`sunshine-junit4`|`sunshine-core`
---|---|---|---
Library|[![](https://img.shields.io/maven-central/v/org.tatools/sunshine-testng.svg)](https://search.maven.org/search?q=g:%22org.tatools%22%20AND%20a:%22sunshine-testng%22)|[![](https://img.shields.io/maven-central/v/org.tatools/sunshine-junit4.svg)](https://search.maven.org/search?q=g:%22org.tatools%22%20AND%20a:%22sunshine-junit4%22)|[![](https://img.shields.io/maven-central/v/org.tatools/sunshine-core.svg)](https://search.maven.org/search?q=g:%22org.tatools%22%20AND%20a:%22sunshine-core%22)
Javadoc|[![](https://www.javadoc.io/badge/org.tatools/sunshine-testng.svg)](https://www.javadoc.io/doc/org.tatools/sunshine-testng)|[![](https://www.javadoc.io/badge/org.tatools/sunshine-junit4.svg)](https://www.javadoc.io/doc/org.tatools/sunshine-junit4)|[![](https://www.javadoc.io/badge/org.tatools/sunshine-core.svg)](https://www.javadoc.io/doc/org.tatools/sunshine-core)


`sunshine-junit4` was tested on `4.11` version of JUnit4 and `sunshine-testng` on `6.11` version of TestNG.

Since `0.4.x` version Sunshine uses `org.tatools` group ID. If you need the earlier version
please use `io.github.tatools` instead.
