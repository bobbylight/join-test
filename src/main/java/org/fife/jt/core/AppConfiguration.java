package org.fife.jt.core;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@ComponentScan("org.fife.jt")
@EnableJpaRepositories(basePackages = "org.fife.jt.repositories")
@EntityScan(basePackages = "org.fife.jt.model")
@EnableSpringDataWebSupport
public class AppConfiguration {
}
