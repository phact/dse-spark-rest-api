#!/bin/bash
set -x

curl -X POST \
  http://localhost:8090/jars/testJob \
  -H 'cache-control: no-cache' \
  --data-binary @job-server-job/target/writeRead-0.1.jar

curl -d "input.string = sdfsf ewf we create" 'localhost:8090/jobs?appName=testJob&classPath=com.datastax.spark.example.WriteRead'

curl -X POST "localhost:8090/contexts/testContext?num-cpu-cores=4&memory-per-node=512m"
curl localhost:8090/contexts
curl -d "input.string = sdfsf ewf we create" 'localhost:8090/jobs?appName=testJob&classPath=com.datastax.spark.example.WriteRead&context=testContext'


#/code dse spark --conf spark.akka.timeout=10000
