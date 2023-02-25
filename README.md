# Custom Strimzi Pod Security Providers

This repository contains example of a custom Strimzi Pod Security Provider.
It is used in a blog post on the Strimzi blog.

## Building the project

### Prerequisites

* Install Java 17, Maven and Docker.

### Java build

* Build the Java JAR file with the custom policies

### Docker build

* Build the container image with the additional JAR file:
  ```
  docker build -t quay.io/scholzj/operator:custom-providers .
  ```
  _(Note: Update the command to use your registry)_

This repository contains some simple examples of how to use the Strimzi `api` module.
The examples are currently based on the Strimzi 0.33.2 release.
The `api` module is available in [Maven repositories](https://mvnrepository.com/artifact/io.strimzi/api), so it can be easily integrated into your Java applications. 
It can be used together with the [Fabric8 Kubernetes Client](https://github.com/fabric8io/kubernetes-client) to manage Strimzi resources in your Kubernetes cluster.

## Installation examples

* `Install`: Installs the Strimzi Cluster Operator
* `Uninstall`: Uninstalls the Strimzi Cluster Operator

## Kafka examples

* `CreateKafka`: Deploys Kafka cluster
* `CreateKafka`: Updates the Kafka cluster and waits for the rolling update to complete
* `DeleteKafka`: Deletes the Kafka cluster

## Connect examples

* `CreateConnectAndConnector`: Deploys Kafka Connect, Kafka topic and two connectors 
* `DeleteConnectAndConnector`: Delete Kafka Connect, Kafka topic and two connectors
* `PauseConnector`: Example which pauses an existing Kafka Connect connector
* `UnpauseConnector`: Example which pauses an existing Kafka Connect connector

## Cruise Control examples

* `CreateRebalance`: Triggers and approves cluster rebalance using Cruise Control and the `KafkaRebalance` custom resource 
* `DeleteRebalance`: Deletes the `KafkaRebalance` resource after a rebalance