package raccoon.gym.controladora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import raccoon.gym.entidades.Pago;

@Controller
public class PagoController {

    @GetMapping("/nuevo-pago")
    public String mostrarFormularioPago(Model model) {
        Pago pago = new Pago();
        model.addAttribute("pago", pago);
        return "formulario_pago";
    }
}
