---
date: 2017-09-07T22:35:05-04:00
title: Spark REST API
menu:
  main:
      parent: Options
      identifier: restapi
      weight: 101
---

## Spark REST API (do not use)

Customers that need remote Spark submission via REST often find out about the undocumented Spark REST api, which appears to be sufficient to meet the requirement. However, be aware that the Spark REST API is not supported by DataStax or by the spark communtiy.

Note: Starting with DSE 5.1 we are able to automatically find the Master for job submissions and allow the selection of a local datacenter for a spark job by using the dse:// syntax in the .master property. The implementation of dse:// has broken compatibility with the Spark RESTful API in 5.1.0.
