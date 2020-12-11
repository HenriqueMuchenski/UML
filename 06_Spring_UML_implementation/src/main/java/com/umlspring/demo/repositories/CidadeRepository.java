package com.umlspring.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.umlspring.demo.domain.Cidade;

// Definindo esta INTERFACE como um componente de repositorio.
// Realiza operações de acesso a dados referente a Cidade.
@Repository
// JpaRepository<ClasseModelo, ChavePrimariaDaClasseModelo>
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
