package com.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapi.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByUserId(String userId);
    
}
