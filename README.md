# Sunshine
Sunshine allows you to manage suits of your automated tests directly from Java code. It supports
[TestNg](https://testng.org/doc/index.html), [JUnit 4](https://junit.org/junit4/), and
[JUnit 5](https://junit.org/junit5/).

Please read the users documentation on [http://sunshine.tatools.org](http://sunshine.tatools.org).

[![Build Status](https://github.com/tatools/sunshine/workflows/Quality%20pipeline/badge.svg)](https://github.com/tatools/sunshine/actions?workflow=Quality+pipeline)
[![Documentation Status](https://readthedocs.org/projects/sunshine/badge/?version=latest)](http://sunshine.tatools.org/en/latest/?badge=latest)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b9ccdf7644db4658bb998eb3c8f0689b)](https://www.codacy.com/app/extsoft/sunshine?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=tatools/sunshine&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/74ffce5e-e3be-45b7-9459-98d13f5f4d4e)](https://codebeat.co/projects/github-com-tatools-sunshine-master)
[![codecov](https://codecov.io/gh/tatools/sunshine/branch/master/graph/badge.svg)](https://codecov.io/gh/tatools/sunshine)
[![PDD status](http://www.0pdd.com/svg?name=tatools/sunshine)](http://www.0pdd.com/p?name=tatools/sunshine)

[![assistant: Elegant Git](https://img.shields.io/badge/assistant-Elegant%20Git-000000.svg)](https://github.com/bees-hive/elegant-git)

[![Rultor.com](http://www.rultor.com/b/tatools/sunshine)](http://www.rultor.com/p/tatools/sunshine)

## How to contribute?
If you have any questions or want more functionality, please submit [a new issue](https://github.com/tatools/sunshine/issues/new).

Before sending any pull request, please discuss requirements/changes to be implemented using an existing issue or
by creating a new one.

## Development notes
If you will install <https://elegant-git.bees-hive.org> and use Git via CLI, all required workflows
will be executed automatically. Otherwise, you can do it manually by running `./workflows` script.

### Code formatting
We use <https://github.com/diffplug/spotless> to format the code. Please run
`./gradlew spotlessApply` to call the formatting manually.

### Code assessment
Run `./gradlew` (or `gradlew.bat`). It will execute unit, integration tests, and formatting verifications.

### Docs review
Automatic analysis of documentation changes in not configured. That's why manual validation is required.

The following snippet allows generation of HTML version of the documentation
```bash
cd docs
rm -r _build && make html
open _build/html/index.html
```

Please take into account, you need to install required Python's dependencies with `pip install -r docs/requirements.txt`
before.
