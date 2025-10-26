package ma.ws.jaxrs.config;

import ma.ws.jaxrs.controllers.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    // Ce bean configure Jersey pour utiliser la classe CompteRestJaxRSAPI comme ressource REST
    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSAPI.class); // Enregistre ton contrôleur JAX-RS
        return jerseyServlet;
    }
}
