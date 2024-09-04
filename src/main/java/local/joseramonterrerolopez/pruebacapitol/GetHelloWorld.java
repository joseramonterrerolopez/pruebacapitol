package local.joseramonterrerolopez.pruebacapitol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetHelloWorld {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
