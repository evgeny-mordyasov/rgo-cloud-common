package rgo.cloud.common.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rgo.cloud.common.spring.aspect.TransactionalAspect;
import rgo.cloud.common.spring.aspect.ValidateAspect;

@Configuration
@Import({ ValidateAspect.class, TransactionalAspect.class })
public class AspectConfig {
}
