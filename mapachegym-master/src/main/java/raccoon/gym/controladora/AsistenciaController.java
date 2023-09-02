package raccoon.gym.controladora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import raccoon.gym.entidades.Asistencia;

@Controller
public class AsistenciaController {

    @GetMapping("/nueva-asistencia")
    public String mostrarFormularioAsistencia(Model model) {
        Asistencia asistencia = new Asistencia();
        model.addAttribute("asistencia", asistencia);
        return "formulario_asistencia";
    }
}
