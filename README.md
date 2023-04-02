# Custom Strimzi Pod Security Providers

This repository contains an example of a custom Strimzi Pod Security Provider.
It is used in a blog post on the Strimzi blog.

## Examples

This repository contains two examples of custom providers:
* `CustomPodSecurityProvider` is written from scratch by implementing the `PodSecurityProvider` interface.
  It runs all containers with a read-only root filesystem.
* `CustomPodSecurityProvider2` is written by extending the Strimzi _restricted_ provider.
  But unlike the original restricted provider, it allows to run Kafka Connect Build using the Kaniko builder which requires running as root.
  All other Pods / containers are using the restricted policies.

## Building the project

### Prerequisites

* Install Java 17, Maven, and Docker.

### Java build

* Build the Java JAR file with the custom policies
  ```
  mvn clean package
  ```

### Docker build

* Build the container image with the additional JAR file:
  ```
  docker build -t quay.io/scholzj/operator:custom-providers .
  ```
  _(Note: Update the command to use your container registry and repository.)_

* Push the image to the repository:
  ```
  docker push quay.io/scholzj/operator:custom-providers
  ```
  _(Note: Update the command to use your container registry and repository.)_

### Deploy it

* Use the newly built image in the Strimzi Cluster Operator deployment

* In the Strimzi Cluster Operator Deployment, set the `JAVA_CLASSPATH` environment variable to `lib/custom-pod-security-providers-1.0-SNAPSHOT.jar` (supported only from Strimzi 0.34.0):
  ```
        - name: JAVA_CLASSPATH
          value: lib/custom-pod-security-providers-1.0-SNAPSHOT.jar
  ```

* And configure the Pod Security Provider.
  For example:
  ```
        - name: STRIMZI_POD_SECURITY_PROVIDER_CLASS
          value: cz.scholz.providers.CustomPodSecurityProvider
  ```

### Use it

Deploy a Kafka cluster using one of the [Strimzi examples](https://github.com/strimzi/strimzi-kafka-operator/tree/main/examples).
Once it is deployed, you can check its Security Context and you should see that all containers will have the read-only root filesystem option enabled.
For example:

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: my-cluster-kafka-0
  # ...
spec:
  # ...
  containers:
    name: kafka
    securityContext:
      readOnlyRootFilesystem: true
    # ...
```