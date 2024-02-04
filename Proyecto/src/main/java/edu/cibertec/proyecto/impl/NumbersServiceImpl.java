package edu.cibertec.proyecto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.CapsulaNumber;
import edu.cibertec.proyecto.repositories.NumbersRepository;
import edu.cibertec.proyecto.services.NumbersService;

@Service
public class NumbersServiceImpl implements NumbersService {
    @Autowired
    NumbersRepository rn;

    @Override
    public CapsulaNumber buscarNumeracion(Long id) {
        CapsulaNumber num = rn.findById(id).orElse(null);
        int correl = num.getNumeracion() + 1;
        num.setNumeracion(correl);
        rn.save(num);
        return rn.findById(id).orElse(null);
    }
}
