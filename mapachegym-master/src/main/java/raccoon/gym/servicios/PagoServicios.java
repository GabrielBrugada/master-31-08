package raccoon.gym.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raccoon.gym.entidades.Pago;
import raccoon.gym.repositorios.PagoRepositorio;

@Service
public class PagoServicios {

    @Autowired
    PagoRepositorio pagoRepositorio;

    public List<Pago> getAll() {
        List<Pago> lista = new ArrayList<Pago>();
        pagoRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;

    }

    public Pago getById(Long id) {
        return pagoRepositorio.findById(id).get();
    }

    public void save(Pago pago) {
        pagoRepositorio.save(pago);
    }

    public void delete(Long id) {
        pagoRepositorio.deleteById(id);
    }
}
