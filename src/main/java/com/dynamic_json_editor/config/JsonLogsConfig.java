package com.dynamic_json_editor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JsonLogsConfig {

    @Bean
    ObjectMapper initObjectMapper() {
		
		return new ObjectMapper();
	}

}
