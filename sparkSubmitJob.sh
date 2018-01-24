#!/bin/bash
set -x
dse spark-submit --class com.datastax.spark.example.WriteRead spark-job/target/writeRead-0.1.jar
