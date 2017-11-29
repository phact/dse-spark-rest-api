---
date: 2017-05-19T21:52:39
title: DSE Spark Rest API Example
type: index
weight: 0
---

This is a guide for how to use the Semi-Secret Spark RESTful API. In the future it may be expanded to include other ways of running/submitting Analytics jobs in DSE and their pros and cons.

### Motivation

DSE Analytics jobs (both bulk and streaming) must be submitted to the cluster in order to be executed.

Depending on user requirements, there are a few different ways of doing so. This asset describes the pros and cons of each and demonstrates how to use the undocumented Spark RESTful API.

### What is included?

This field asset includes a simple batch analytics application (borrowed from Russ: https://github.com/RussellSpitzer/ProgrammaticSparkExample) and describes how to use:

* `dse spark-submit`
* Undocumented Spark RESTFUL API

To submit it to the cluster. Other alternatives for execution include
* `dse spark-client`
* spark job server

### Business Take Aways

In analytics use cases, Business stakeholders depend on timely and trackable runs of their business logic to satisfy analytical requirements. This asset helps their technical counterparts support these needs.

### Technical Take Aways

The prefered method for submitting spark applications (whether remotely using `dse client-tool` or from the cluster itself) is `dse spark-submit`. DSE takes care of setting environmental variables and identifying the Spark master for application submission automatically simplifying availability requirements of spark applications.

However, some users require the ability to submit spark jobs remotely via REST. In these cases, customers often find out about job server and incurr the complexity that goes along with job server to achieve REST submission. In many cases the undocumented Spark REST api is enough. This asset shows how simple it is to use it.

Note: Starting with DSE 5.1 we are able to automatically find the Master for job submissions and allow the selection of a local datacenter for a spark job by using the `dse://` syntax in the `.master` property. The implementation of `dse://` has broken compatibility with the Spark RESTful API in 5.1.0 - 5.1.4.
