package the.jpas.product.management.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI openAPI(){
    return new OpenAPI()
              .info(
                    new Info()
                            .title("Products Management API")
                            .description("Some custom description of API.")
                            .version("1.0")
                            .contact(new Contact().name("Jose Luis Teran")
                                    .email( "huesos@gmail.com").url("www.huesos.com")
                            )
                            .license(new License().name("License of API")
                                    .url("API license URL")));
  }
}
