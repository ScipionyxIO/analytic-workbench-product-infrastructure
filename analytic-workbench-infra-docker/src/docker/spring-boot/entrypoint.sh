#!/bin/sh

if [ $USE_CLOUD == 'true' ]
then
echo "Using Spring Cloud Config Profile:" ${USE_PROFILES} Url: ${USE_URL} Label: ${USE_LABEL}
JAVA_OPTS=-Dspring.cloud.config.uri=${USE_URI} -Dspring.cloud.config.label=${USE_LABEL} -Dspring.application.profiles=${USE_PROFILES}
fi

exec java $JAVA_OPTS -jar $ENV_JAR_NAME "$@"