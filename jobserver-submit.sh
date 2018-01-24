#!/bin/bash
set -x

curl -X POST \
  http://localhost:8090/jars/readWrite \
  -H 'cache-control: no-cache' \
  --data-binary @job-server-job/target/original-writeRead-0.1.jar

curl -X POST "localhost:8090/jobs?appName=readWrite&classPath=com.datastax.spark.example.WriteRead"


curl -X POST "localhost:8090/contexts/test-context?num-cpu-cores=4&memory-per-node=512m"
curl localhost:8090/contexts
curl -X POST "localhost:8090/jobs?appName=readWrite&classPath=com.datastax.spark.example.WriteRead&context=test-context&sync=true"


#/code dse spark --conf spark.akka.timeout=10000
