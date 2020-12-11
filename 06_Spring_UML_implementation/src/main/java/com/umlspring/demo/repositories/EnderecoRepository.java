package com.umlspring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umlspring.demo.domain.Endereco;

// Definindo esta INTERFACE como um componente de repositorio.
// Realiza operações de acesso a dados referente a Endereco.
@Repository
// JpaRepository<ClasseModelo, ChavePrimariaDaClasseModelo>
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
