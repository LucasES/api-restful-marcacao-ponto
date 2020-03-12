package br.com.touchapps.pontoeletronico.config;

import br.com.touchapps.pontoeletronico.security.services.JwtUserDetailsServiceImpl;
import br.com.touchapps.pontoeletronico.security.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuração padrão para Swagger
 *
 * @author Lucas Araújo
 */
@Configuration
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {

    private static final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.touchapps.pontoeletronico.controllers"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Ponto Inteligente API")
                .description("Documentação da API de acesso aos endpoints do Ponto Inteligente")
                .version("1.0")
                .build();
    }

    @Bean
    public SecurityConfiguration securityConfiguration() {
        String token;

        try {
            UserDetails userDetails =
                    this.userDetailsService.loadUserByUsername("admin@gmail.com");
            token = this.jwtTokenUtil.obterToken(userDetails);
        } catch (Exception ex) {
            log.error("Não foi possível obter um token, ex: " + ex.getMessage());
            token = "";
        }

        return new SecurityConfiguration(null, null, null, null, "Bearer " + token,
                ApiKeyVehicle.HEADER, "Authorization", ",");
    }

}
