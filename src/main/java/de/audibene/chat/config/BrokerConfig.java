package de.audibene.chat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;


@Configuration
public class BrokerConfig {

	@Value("${broker.host}")
	String host;

	@NonNull
	@Value("${broker.username}")
	String username;

	@NonNull
	@Value("${broker.password}")
	String password;

    @NonNull
	@Value("${broker.port}")
    Integer port;
}
