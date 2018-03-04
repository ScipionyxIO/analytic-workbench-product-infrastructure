FROM alpine

COPY entrypoint.sh /
COPY wait-for.sh /
COPY *.json /

RUN chmod +x /*.sh

RUN apk add --no-cache curl

ENTRYPOINT ["/entrypoint.sh"]

