package com.batch.consumer.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.batch.consumer.model.Employee;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	public KafkaConsumerConfig()
	{
		
	}
	@Bean
	public ConsumerFactory<String,Employee> consumerFactory()
	{
		JsonDeserializer<Employee> deserializer=new JsonDeserializer<>(Employee.class);
		deserializer.addTrustedPackages("*");
		deserializer.setUseTypeMapperForKey(true);
		return new DefaultKafkaConsumerFactory<>(consumerConfig(),new StringDeserializer(),deserializer);
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,Employee> kafkaListenerContainerFactory()
	{
		ConcurrentKafkaListenerContainerFactory<String,Employee> factory=new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
		
	}
	@Bean
	public Map<String,Object> consumerConfig() {
		// TODO Auto-generated method stub
		JsonDeserializer<Employee> deserializer=new JsonDeserializer<>(Employee.class);
		deserializer.addTrustedPackages("*");
		deserializer.setUseTypeMapperForKey(true);
		Map<String,Object> propMap=new HashMap<>();
		propMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		propMap.put(ConsumerConfig.GROUP_ID_CONFIG, "boot");
		propMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		propMap.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, "123456");
		propMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propMap.put(ConsumerConfig.GROUP_ID_CONFIG, "json");
		propMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
		propMap.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, "2000");
		return propMap;
	}

}
