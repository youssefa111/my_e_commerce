package com.youssefhussien.my_e_commerce.config;

import com.youssefhussien.my_e_commerce.core.utils.ConvertJsonFileToJsonObject;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.io.IOException;

@Configuration
@OpenAPIDefinition
@SecurityScheme(
        name = "token",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI baseOpenApi() throws IOException {



        ApiResponse badRequestAPI = new ApiResponse().content(
                new Content().addMediaType(
                        MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples(
                                "default",
                                new Example().value(ConvertJsonFileToJsonObject.read("src/main/resources/openapi/errorResponse.json").get("badRequestResponse").toString())))).description("Bad Request!");

        ApiResponse internalServerErrorAPI =  new ApiResponse().content(
                new Content().addMediaType(
                        MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples(
                                "default",
                                new Example().value(
                                        ConvertJsonFileToJsonObject.read("src/main/resources/openapi/errorResponse.json").get("internalServerErrorResponse").toString())))).description("Internal Server Error!");

        ApiResponse recordNotFoundExceptionAPI =  new ApiResponse().content(
                new Content().addMediaType(
                        MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples(
                                "default",
                                new Example().value(
                                        ConvertJsonFileToJsonObject.read("src/main/resources/openapi/errorResponse.json").get("recordNotFoundExceptionResponse").toString())))).description("Record Not Found in Database");

        ApiResponse duplicateRecordExceptionAPI =  new ApiResponse().content(
                new Content().addMediaType(
                        MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples(
                                "default",
                                new Example().value(
                                        ConvertJsonFileToJsonObject.read("src/main/resources/openapi/errorResponse.json").get("duplicateRecordExceptionResponse").toString())))).description("Enter Data into database cannot be duplicated");

        Components components = new Components();
        components.addResponses("badRequestAPI",badRequestAPI);
        components.addResponses("internalServerErrorAPI",internalServerErrorAPI);
        components.addResponses("recordNotFoundExceptionAPI",recordNotFoundExceptionAPI);
        components.addResponses("duplicateRecordExceptionAPI",duplicateRecordExceptionAPI);

        return new OpenAPI()
                .components(components)
                .info(new Info()
                        .title("E-learning Backend Doc")
                        .version("1.0.0")
                        .description("Apis Docs"));
    }
}
