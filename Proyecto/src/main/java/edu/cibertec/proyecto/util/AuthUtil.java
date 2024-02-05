package edu.cibertec.proyecto.util;

import edu.cibertec.proyecto.entity.CapsulaUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class AuthUtil {
    public ResponseEntity<MessageUtil> responseEntityMono(Optional<CapsulaUsuario> findFunc, String msgSuccess, String msgFail) {
        return findFunc.map(u -> ResponseEntity.ok()
                        .body(MessageUtil.builder()
                                .message(msgSuccess)
                                .timestamp(new Date())
                                .status(HttpStatus.OK.value())
                                .result(u)
                                .build()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(MessageUtil.builder()
                                .message(msgFail)
                                .timestamp(new Date())
                                .status(HttpStatus.NOT_FOUND.value())
                                .build()));
    }
}
