package com.umlspring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umlspring.demo.domain.Produto;

// Definindo esta INTERFACE como um componente de repositorio.
// Realiza operações de acesso a dados referente a Produto.
@Repository
// JpaRepository<ClasseModelo, ChavePrimariaDaClasseModelo>
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
