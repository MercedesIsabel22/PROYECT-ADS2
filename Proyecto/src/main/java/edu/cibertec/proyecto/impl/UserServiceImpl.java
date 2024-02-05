package edu.cibertec.proyecto.impl;

import edu.cibertec.proyecto.entity.CapsulaUsuario;
import edu.cibertec.proyecto.repositories.IUsuariosRepository;
import edu.cibertec.proyecto.security.AuthProvider;
import edu.cibertec.proyecto.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUsuariosRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthProvider authProvider;

    @Override
    public Optional<CapsulaUsuario> create(CapsulaUsuario user) {
        return Optional.of(repository.save(user));
    }

    @Override
    public Optional<CapsulaUsuario> update(CapsulaUsuario user) {
        Optional<CapsulaUsuario> u = repository.findById(user.getIdusuario());
        if (u.isPresent()) {
            return Optional.of(repository.save(user));
        }
        return Optional.empty();
    }

    @Override
    public Optional<CapsulaUsuario> findByUsername(String username) {
        return repository.findByUsuario(username);
    }

    @Override
    public Optional<CapsulaUsuario> signIn(CapsulaUsuario user) {
        return Optional.ofNullable(repository.findByUsuario(user.getUsuario())
                .map(u -> {
                    boolean isValid = passwordEncoder.matches(user.getClave(), u.getClave());
                    if (isValid) {
                        final String token = authProvider.createToken(u);
                        log.info(String.format("Token: %s", token));
                        u.setClave("");
                        u.setToken(token);
                        return u;
                    }
                    return null;
                }).orElseGet(() -> null));
    }

    @Override
    public CapsulaUsuario findUserById(Long id) {
        return repository.findById(id)
                .orElseGet(() -> null);
    }

    @Override
    public List<CapsulaUsuario> findAll() {
        return repository.findAll();
    }
}
