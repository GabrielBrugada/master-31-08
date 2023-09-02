package raccoon.gym.controladora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import raccoon.gym.entidades.Cliente;

@Controller
public class ClienteController {

    @GetMapping("/nuevo-cliente")
    public String mostrarFormularioCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "formulario_cliente";
    }
}
