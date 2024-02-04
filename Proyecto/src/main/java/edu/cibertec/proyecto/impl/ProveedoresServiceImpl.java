package edu.cibertec.proyecto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.CapsulaProveedor;
import edu.cibertec.proyecto.repositories.ProveedoresRepository;
import edu.cibertec.proyecto.services.ProveedoresService;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
    @Autowired
    ProveedoresRepository rp;

    @Override
    public List<CapsulaProveedor> listar() {

        return rp.findByEstado(1);
    }

    @Override
    public CapsulaProveedor buscarProveedor(Long codigo) {

        return rp.findById(codigo).orElse(null);
    }

    @Override
    public void eliminarProveedor(CapsulaProveedor obj) {
        CapsulaProveedor prov = rp.findById(obj.getIdproveedor()).orElse(null);
        prov.setEstado(0);
        rp.save(prov);

    }

    @Override
    public void modificarProveedor(CapsulaProveedor obj) {
        CapsulaProveedor prov = rp.findById(obj.getIdproveedor()).orElse(null);
        prov.setIdproveedor(obj.getIdproveedor());
        prov.setCelular(obj.getCelular());
        prov.setCorreo(obj.getCorreo());
        prov.setRazonsocial(obj.getRazonsocial());
        prov.setRucdni(obj.getRucdni());
        prov.setEstado(1);
        rp.save(prov);
    }

    @Override
    public void crearProveedor(CapsulaProveedor obj) {
        rp.save(obj);

    }

}
