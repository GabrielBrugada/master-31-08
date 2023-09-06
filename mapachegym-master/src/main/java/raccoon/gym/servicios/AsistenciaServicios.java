package raccoon.gym.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import raccoon.gym.entidades.Asistencia;
import raccoon.gym.repositorios.AsistenciaRepositorio;

@Service
public class AsistenciaServicios {

    @Autowired
    AsistenciaRepositorio asistenciaRepositorio;

    public List<Asistencia> getAll() {
        List<Asistencia> lista = new ArrayList<Asistencia>();
        asistenciaRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;

    }

    public Asistencia getById(Long id) {
        return asistenciaRepositorio.findById(id).get();
    }

    public void save(Asistencia asistencia) {
        asistenciaRepositorio.save(asistencia);
    }
     public void guardarAsistencia(@Valid Asistencia asistencia) {
    }
    public List<Asistencia> obtenerTodasLasAsistencias() {
        List<Asistencia> listaAsistencias = new ArrayList<Asistencia>();
        asistenciaRepositorio.findAll().forEach(registro -> listaAsistencias.add(registro));
        return listaAsistencias;
    }

    public void delete(Long id) {
        asistenciaRepositorio.deleteById(id);
    }
}
