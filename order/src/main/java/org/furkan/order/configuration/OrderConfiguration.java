package org.furkan.order.configuration;

import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {
                "org.furkan.order",
                "io.craftgate.modulith.messaging.api"
        },
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = {DomainComponent.class}
                )
        }
)
public class OrderConfiguration {
}
