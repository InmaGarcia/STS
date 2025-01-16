package Tema4Ej10.Servicio;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tema4Ej10.Modelo.Oficina;
import Tema4Ej10.Repositorio.OficinaRepositorioImp;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OficinaServicioImp implements OficinaServicio{
	
	@Autowired
    private OficinaRepositorioImp oficinaRepo;

    @Override
    public void crearOficina(Oficina oficina) {
    	oficinaRepo.save(oficina);
    }

    @Override
    public Oficina obtenerOficinaPorId(Integer id) {
        return oficinaRepo.findById(id);
    }

    @Override
    public List<Oficina> listarOficinas() {
        return oficinaRepo.findAll();
    }

    @Override
    public void eliminarOficina(Integer id) {
    	oficinaRepo.deleteById(id);
    }

    @Override
    public long contarEmpleadosEnOficina(Integer oficinaId) {
        return oficinaRepo.countEmpleadosInOficina(oficinaId);
    }

    @Override
    public Map<Integer, Long> empleadosPorOficina() {
        return oficinaRepo.getEmpleadosCountPerOficina();
    }

    @Override
    public List<Oficina> oficinasConMasDeNEmpleados(int n) {
        return oficinaRepo.findByMinEmpleados(n);
    }

    @Override
    public void actualizarTelefonoOficinaPorEmpleadoId(Integer empleadoId, String nuevoTelefono) {
    	oficinaRepo.updateTelefonoByEmpleadoId(empleadoId, nuevoTelefono);
    }
}
