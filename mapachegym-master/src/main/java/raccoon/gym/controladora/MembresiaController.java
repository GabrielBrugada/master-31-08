package raccoon.gym.controladora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import raccoon.gym.entidades.Membresia;

@Controller
public class MembresiaController {

    @GetMapping("/nueva-membresia")
    public String mostrarFormularioMembresia(Model model) {
        Membresia membresia = new Membresia();
        model.addAttribute("membresia", membresia);
        return "formulario_membresia";
    }
}
