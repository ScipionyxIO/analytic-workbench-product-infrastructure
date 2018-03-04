package io.scipionyx.analyticworkbench.infra.elastic;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = { "io.scipionyx.analyticworkbench" })
@EnableConfigurationProperties(ElasticMetadata.class)
public class ElasticInfraConfiguration {

	// public @Bean Client client(@Autowired ElasticMetadata metadata) throws
	// Exception {
	// Settings esSettings = Settings.settingsBuilder().put("cluster.name",
	// metadata.getClusterName()).build();
	// TransportClient client =
	// TransportClient.builder().settings(esSettings).build();
	// List<String> nodes = Arrays.asList(metadata.getNodes().split(","));
	// for (String node : nodes) {
	// InetAddress inetAddress = InetAddress.getByName(node.split(":")[0]);
	// InetSocketTransportAddress inetSocketTransportAddress = new
	// InetSocketTransportAddress(inetAddress,
	// Integer.valueOf(node.split(":")[1]));
	// client = client.addTransportAddress(inetSocketTransportAddress);
	// }
	// return client;
	// }

	// public @Bean ScipionyxEntityMapper getEntityMapper(@Autowired
	// ScipionyxObjectMapper objectMapper) {
	// return new ScipionyxEntityMapper(objectMapper);
	// }

	// @Bean
	// public ElasticsearchTemplate elasticsearchTemplate(@Autowired Client client,
	// @Autowired EntityMapper entityMapper) {
	// return new ElasticsearchTemplate(client, entityMapper);
	// }

}
