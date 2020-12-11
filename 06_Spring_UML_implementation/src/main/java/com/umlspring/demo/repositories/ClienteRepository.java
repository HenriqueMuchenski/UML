package com.umlspring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umlspring.demo.domain.Cliente;

// Definindo esta INTERFACE como um componente de repositorio.
// Realiza operações de acesso a dados referente a Cliente.
@Repository
// JpaRepository<ClasseModelo, ChavePrimariaDaClasseModelo>
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
