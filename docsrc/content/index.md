---
date: 2017-05-19T21:52:39
title: DSE Spark Submit Options
type: index
weight: 0
---

This is a guide for how to submit spark jobs through the various API options available and their pros and cons.

### Motivation

DSE Analytics jobs (both bulk and streaming) must be submitted to the cluster in order to be executed.

Depending on user requirements, there are a few different ways of doing so. This asset describes the pros and cons of each.

### What is included?

This field asset includes a simple batch analytics application and describes how to use the:

* `dse spark-submit`
* `dse spark-client` to configure a remote spark submit with dse binaries
* spark job server
* Undocumented Spark RESTFUL API (do not use)

### Business Take Aways

In analytics use cases, Business stakeholders depend on timely and trackable runs of their business logic to satisfy analytical requirements. This asset helps their technical counterparts support these needs.

### Technical Take Aways

The preffered method for submitting spark applications (whether remotely using `dse client-tool` or from the cluster itself) is `dse spark-submit`. DSE takes care of setting environmental variables and identifying the Spark master for application submission automatically simplifying availability requirements of spark applications.

However, some users require the ability to submit spark jobs remotely via REST. In these cases it is necessary to look into other options.
