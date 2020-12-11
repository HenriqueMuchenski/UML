package com.umlspring.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.umlspring.demo.domain.Estado;

// Definindo esta INTERFACE como um componente de repositorio.
// Realiza operações de acesso a dados referente a Estado.
@Repository
// JpaRepository<ClasseModelo, ChavePrimariaDaClasseModelo>
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
