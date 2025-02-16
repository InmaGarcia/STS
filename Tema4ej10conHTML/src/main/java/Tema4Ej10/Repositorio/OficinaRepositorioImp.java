package Tema4Ej10.Repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Tema4Ej10.Modelo.Empleado;
import Tema4Ej10.Modelo.Oficina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OficinaRepositorioImp implements OficinaRepositorio{

	 @PersistenceContext
	 private EntityManager entityManager;
	 
    @Override
    public void save(Oficina oficina) {
        if (oficina.getId() == null) {
            entityManager.persist(oficina);
        } else {
            entityManager.merge(oficina);
        }
    }

    @Override
    public Oficina findById(Integer id) {
        return entityManager.find(Oficina.class, id);
    }

    @Override
    public List<Oficina> findAll() {
        return entityManager.createQuery("SELECT o FROM Oficina o", Oficina.class).getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        Oficina oficina = findById(id);
        if (oficina != null) {
            entityManager.remove(oficina);
        }
    }

    @Override
    public long countEmpleadosInOficina(Integer oficinaId) {
        return entityManager.createQuery("SELECT COUNT(e) FROM Empleado e WHERE e.oficina.id = :oficinaId", Long.class)
                .setParameter("oficinaId", oficinaId)
                .getSingleResult();
    }

    @Override
    public Map<Integer, Long> getEmpleadosCountPerOficina() {
        Map<Integer, Long> countEmp = new HashMap<>();
        List<Oficina> oficinas = findAll();
        for (Oficina oficina : oficinas) {
            long count = countEmpleadosInOficina(oficina.getId());
            countEmp.put(oficina.getId(), count);
        }
        return countEmp;
    }

    @Override
    public List<Oficina> findByMinEmpleados(int minEmpleados) {
        return entityManager.createQuery("SELECT o FROM Oficina o WHERE (SELECT COUNT(e) FROM Empleado e WHERE e.oficina = o) > :minEmpleados", Oficina.class)
                .setParameter("minEmpleados", (long) minEmpleados)
                .getResultList();
    }

    public void updateTelefonoByEmpleadoId(Integer empleadoId, String nuevoTelefono) {
        Empleado empleado = entityManager.find(Empleado.class, empleadoId);
        if (empleado != null && empleado.getOficina() != null) {
            Oficina oficina = empleado.getOficina();
            oficina.setTelefono(nuevoTelefono);
            entityManager.merge(oficina);
        }
    }
}
