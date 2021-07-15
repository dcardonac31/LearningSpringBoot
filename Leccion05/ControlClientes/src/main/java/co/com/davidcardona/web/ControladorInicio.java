package co.com.davidcardona.web;

import com.co.davidcardona.servicio.IPersonaService;
import com.co.davidcardona.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private IPersonaService ipersonaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var personas = ipersonaService.listarPersonas();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
}
