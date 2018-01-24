---
date: 2017-09-07T22:35:05-04:00
title: Job Server
menu:
  main:
      parent: Options
      identifier: jobserver
      weight: 101
---

## JobServer

JobServer is an open source tool built and maintained by Evan Chan. We ship it with DSE because it provides useful capabilities for advanced Spark users. However, it does come with complexity:

* More moving parts
* More dependency management (jobserver jobs must be built with the jobserverpai version shipped in the version of DSE that is being used)
* Job server jobs must implement jobserver classes. Standard Spark jobs do not work
* Python support ships in .8 (coming in DSE 6.0) older versions of DSE will not support python in jobserver.

Job server provides some benefits aside from remote REST submission for more complex use cases.

* jobserver UI on port 8090
* remote REST submission
* shared spark context - better performance since the job can be run on an existing spark application (this is the same tactic used by sparksql thriftserver)
