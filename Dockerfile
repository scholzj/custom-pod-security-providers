FROM quay.io/strimzi/operator:0.33.2

USER root:root

COPY ./target/*.jar lib/

USER 1001