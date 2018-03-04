FROM elasticsearch:2.4.6-alpine

MAINTAINER Renato Mendes <rmendes@mediamorph.com>

RUN /usr/share/elasticsearch/bin/plugin install mobz/elasticsearch-head

# RUN 	echo 'jmx.create_connector: true' >> /usr/share/elasticsearch/config
# RUN	echo 'jmx.port: 9333' >> /usr/share/elasticsearch/config
# RUN	echo 'jmx.domain: elasticsearch' >> /usr/share/elasticsearch/config

# ENV ES_JAVA_OPTS '-Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=9333 -Dcom.sun.management.jmxremote.rmi.port=9334'