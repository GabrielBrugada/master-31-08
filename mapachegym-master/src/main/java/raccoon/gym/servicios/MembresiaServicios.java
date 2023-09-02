package raccoon.gym.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raccoon.gym.entidades.Membresia;
import raccoon.gym.repositorios.MembresiaRepositorio;

@Service
public class MembresiaServicios {

    @Autowired
    MembresiaRepositorio membresiaRepositorio;

    public List<Membresia> getAll() {
        List<Membresia> lista = new ArrayList<Membresia>();
        membresiaRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;

    }

    public Membresia getById(Long id) {
        return membresiaRepositorio.findById(id).get();
    }

    public void save(Membresia membresia) {
        membresiaRepositorio.save(membresia);
    }

    public void delete(Long id) {
        membresiaRepositorio.deleteById(id);
    }
}
