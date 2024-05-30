package org.furkan.configuration;

import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {
                "org.furkan",
                "io.craftgate.modulith.messaging.api"
        },
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = {DomainComponent.class}
                )
        }
)
public class PaymentConfiguration {
}
