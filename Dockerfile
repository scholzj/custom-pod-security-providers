FROM quay.io/strimzi/operator:0.34.0

USER root:root

COPY ./target/*.jar lib/

USER 1001