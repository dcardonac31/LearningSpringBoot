package co.com.davidcardona;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ControladorInicio {

    @GetMapping("/")
    public String inicio(){
        log.info("ejecutando el controlador rest");
        log.info("mas detalle del controlador");
        return "HolaMundo con Spring";
    }
}
