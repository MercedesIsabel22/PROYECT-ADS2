package edu.cibertec.proyecto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.CapsulaNumber;
import edu.cibertec.proyecto.repositories.INumbersRepository;
import edu.cibertec.proyecto.services.INumbersService;

@Service
public class NumbersServiceImpl implements INumbersService {
    @Autowired
    INumbersRepository rn;

    @Override
    public CapsulaNumber buscarNumeracion(Long id) {
        CapsulaNumber num = rn.findById(id).orElse(null);
        int correl = num.getNumeracion() + 1;
        num.setNumeracion(correl);
        rn.save(num);
        return rn.findById(id).orElse(null);
    }
}
