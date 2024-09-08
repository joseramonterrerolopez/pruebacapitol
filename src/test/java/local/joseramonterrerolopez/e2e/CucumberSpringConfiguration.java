package local.joseramonterrerolopez.e2e;

import io.cucumber.spring.CucumberContextConfiguration;
import local.joseramonterrerolopez.pruebacapitol.PruebacapitolApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = PruebacapitolApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {
    @Value("${local.server.port}")
    private Integer port;

    public Integer port() {
        return port;
    }
}

