package com.umlspring.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.umlspring.demo.domain.ItemPedido;

// Definindo esta INTERFACE como um componente de repositorio.
// Realiza operações de acesso a dados referente a ItemPedido.
@Repository
// JpaRepository<ClasseModelo, ChavePrimariaDaClasseModelo>
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
