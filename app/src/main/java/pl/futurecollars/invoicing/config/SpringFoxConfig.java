package pl.futurecollars.invoicing.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {

  @Bean
  public OpenApiCustomizer openApiCustomizer() {
    return openApi -> {
      openApi
          .info(new Info()
              .description("Application to manage set of invoices")
              .license(new io.swagger.v3.oas.models.info.License().name("No license available - private!"))
              .title("Private invoicing")
              .contact(new Contact()
                  .name("Bartłomiej Kleszcz")
                  .url("https://github.com/UzurpatorUzbekistanu")
                  .email("bartłomiej@wp.pl"))
          );

      openApi.addTagsItem(new Tag()
          .name("invoice-controller")
          .description("Controller used to list / add / update / delete invoices (CRUD)")
      );
    };
  }
}
