package hu.charmanthere.ease.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
