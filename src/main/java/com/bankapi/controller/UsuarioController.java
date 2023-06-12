package com.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapi.model.Usuario;
import com.bankapi.repository.UsuarioRepository;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repo;

   @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Usuario userData) {
    Usuario usuario = repo.findByUserId(userData.getUserId());
    if (usuario.getPassword().equals(userData.getPassword())) {
        return ResponseEntity.ok(usuario);
    }

    return (ResponseEntity<?>) ResponseEntity.internalServerError();
}

}
