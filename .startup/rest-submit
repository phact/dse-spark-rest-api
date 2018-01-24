#!/bin/bash
set -x

curl -X POST \
  http://localhost:6066/v1/submissions/create \
  -H 'cache-control: no-cache' \
  -d '{
    "action" : "CreateSubmissionRequest",
    "appArgs" : [ "testArg" ],
    "appResource" : "file://'$PWD'/spark-job/target/original-writeRead-0.1.jar",
    "clientSparkVersion" : "2.0.2",
    "environmentVariables" : {
    "SPARK_ENV_LOADED" : "1"
  },
  "mainClass" : "com.datastax.spark.example.WriteRead",
  "sparkProperties" : {
      "spark.driver.supervise" : "false",
      "spark.app.name" : "test",
      "spark.submit.deployMode" : "cluster",
      "spark.executor.cores":"2",
      "spark.cores.max": "2"
  }
}'
