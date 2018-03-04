FROM openjdk:8-alpine

ENV USE_CLOUD=false \
	USE_PROFILES=dev \
	USE_URI=http://spring-cloud-config-server:8888 \
	USE_LABEL=master

COPY entrypoint.sh /
RUN chmod +x entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]