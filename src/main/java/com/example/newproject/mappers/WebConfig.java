package com.example.newproject.mappers;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Create a JSON message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Set the supported media types for the converter
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(supportedMediaTypes);

        // Add the converter to the list of converters
        converters.add(converter);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("/css/");

        registry
                .addResourceHandler("/js/**")
                .addResourceLocations("/js/");
    }
}