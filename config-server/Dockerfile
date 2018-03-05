ARG REGISTRY_BASE=scipionyxio
FROM ${REGISTRY_BASE}/infrastructure-spring-boot

LABEL maintainer "Renato Mendes rmendes@scipionyx.io"

ARG JAR_NAME
ENV ENV_JAR_NAME=${JAR_NAME}

COPY target/${JAR_NAME} /