# Spark Submit Options

This is a guide for how to submit spark jobs through the various API options available and their pros and cons.

### Motivation

From time to time it is necessary to be able to run analytics against the data within Cassandra. The traditional approach would be to extract it to servers running Spark, run analytics against the data and put the results back into Cassandra. DSE with its tight integration with Spark allows analytic jobs to be ran directly against data in DSE Core (Cassandra). DSE Analytics jobs (both bulk and streaming) must be submitted to the cluster in order to be executed. 

Depending on user requirements, there are a few different ways of executing Spark jobs in DSE. This asset describes the pros and cons of each.

### What is included?

This field asset includes a simple batch analytics application and describes how to use the:

* `dse spark-submit`
* Undocumented Spark RESTFUL API

To submit it to the cluster. Other alternatives for execution include
* `dse spark-client`
* spark job server

### Business Takeaways

In analytics use cases, Business stakeholders depend on timely and trackable runs of their business logic to satisfy analytical requirements. This asset helps their technical counterparts support these needs.

### Technical Takeaways

The preferred method for submitting spark applications (whether remotely using `dse client-tool` or from the cluster itself) is `dse spark-submit`. DSE takes care of setting environmental variables and identifying the Spark master for application submission automatically simplifying availability requirements of spark applications.

However, some users require the ability to submit spark jobs remotely via REST. In these cases, customers often find out about job server and incur the complexity that goes along with job server to achieve REST submission. In some cases the undocumented Spark REST api is sufficient to meet the requirement.

Be aware that the Spark REST API is not supported by DataStax or by the spark community.

Note: Starting with DSE 5.1 we are able to automatically find the Master for job submissions and allow the selection of a local datacenter for a spark job by using the `dse://` syntax in the `.master` property. The implementation of `dse://` has broken compatibility with the Spark RESTful API in 5.1.0 and above.
