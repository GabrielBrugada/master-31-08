package raccoon.gym.controladora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import raccoon.gym.entidades.Membresia;
import raccoon.gym.servicios.MembresiaServicios;

@Controller
public class MembresiaController {

    @GetMapping("/nueva-membresia")
    public String mostrarFormularioMembresia(Model model) {
        Membresia membresia = new Membresia();
        model.addAttribute("membresia", membresia);
        return "formulario_membresia";
    }
     @Autowired
    private MembresiaServicios membresiaServicios; // Asegúrate de que tienes el servicio inyectado

    @PostMapping("/guardar-membresia")
    public String guardarMembresia(@ModelAttribute("membresia") @Valid Membresia membresia, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, regresa al formulario de creación
            return "formulario_membresia";
        }

        // Llama al servicio para guardar el membresia
        membresiaServicios.save(membresia);

        // Redirecciona a la página de confirmación o a la lista de membresias
        return "redirect:/lista-membresia";
    }

    @GetMapping("/lista-membresia")
    public String listarMembresias(Model model) {
        List<Membresia> listaMembresias = membresiaServicios.obtenerTodasLasMembresias();
        model.addAttribute("listaMembresias", listaMembresias);
        return "lista-membresia";
    }

    @GetMapping("/editar-membresia/{id}")
    public String editarMembresia(@PathVariable Long id, Model model) {
        Membresia membresia = membresiaServicios.getById(id);
        model.addAttribute("membresia", membresia);
        return "editar-membresia";
    }

    @PostMapping("/actualizar-membresia")
    public String actualizarMembresia(@ModelAttribute("membresia") Membresia membresia) {
        membresiaServicios.save(membresia); // Guarda los cambios en la base de datos
        return "redirect:/lista-membresia";
    }

    @GetMapping("/eliminar-membresia/{id}")
    public String eliminarMembresia(@PathVariable Long id) {
        membresiaServicios.delete(id); // Elimina el membresia de la base de datos
        return "redirect:/lista-membresia";
    }
}
