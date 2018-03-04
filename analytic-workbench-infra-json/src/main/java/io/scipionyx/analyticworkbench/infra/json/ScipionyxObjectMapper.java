package io.scipionyx.analyticworkbench.infra.json;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ScipionyxObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	@PostConstruct
	@SuppressWarnings({ "rawtypes" })
	private void init() {

		// Configure Features
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		this.configure(com.fasterxml.jackson.core.JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

		// Add Modules
		final SimpleModule module = new SimpleModule();

		List<Class<? extends JsonDeserializer>> deserializersList = new ArrayList<>();

		// new
		// FastClasspathScanner("io.scipionyx").matchSubclassesOf(JsonDeserializer.class,
		// deserializersList::add)
		// .scan();

		//
		Map<Class, Class> deserializers = deserializersList.stream()
				.collect(Collectors.toMap(c -> getClass(c), c -> c));

		deserializers.entrySet().forEach(a -> {
			// try {
			// module.addDeserializer(a.getKey(), (JsonDeserializer)
			// a.getValue().newInstance());
			// } catch (InstantiationException | IllegalAccessException e) {
			// e.printStackTrace();
			// }
		});

		//
		this.registerModule(module);

	}

	private Class<?> getClass(@SuppressWarnings("rawtypes") Class<? extends JsonDeserializer> d) {
		return (Class<?>) ((ParameterizedType) d.getGenericSuperclass()).getActualTypeArguments()[0];

	}

}
