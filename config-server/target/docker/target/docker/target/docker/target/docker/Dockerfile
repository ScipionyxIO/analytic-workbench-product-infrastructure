ARG REGISTRY_ADDRESS=192.168.99.100:5000
FROM ${REGISTRY_ADDRESS}/spring-boot

LABEL maintainer "Renato Mendes rmendes@scipionyx.io"

ARG JAR_NAME
ENV ENV_JAR_NAME=${JAR_NAME}

COPY target/${JAR_NAME} /