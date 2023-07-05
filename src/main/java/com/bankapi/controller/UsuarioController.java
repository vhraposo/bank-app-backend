package com.bankapi.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapi.model.Usuario;
import com.bankapi.repository.UsuarioRepository;
import com.bankapi.utils.JwtUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200, https://fxbank.vercel.app/login")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Usuario userData) {
    Usuario usuario = repo.findByUserId(userData.getUserId());

    if (usuario != null && usuario.getPassword().equals(userData.getPassword())) {
        String userId = usuario.getUserId();
        String token = JwtUtil.generateToken(userId);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Credenciais inválidas"));
    }

}
