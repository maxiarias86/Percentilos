package fetal.percentiles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/hola")
    public String hola() {
        return "¡Hola mundo desde Spring Boot!";
    }

    @GetMapping("/")
    public String index() {
        return "index"; // busca index.html en templates
    }

}
