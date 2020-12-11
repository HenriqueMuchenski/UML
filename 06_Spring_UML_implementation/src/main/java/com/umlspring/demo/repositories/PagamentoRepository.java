package com.umlspring.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.umlspring.demo.domain.Pagamento;

// Definindo esta INTERFACE como um componente de repositorio.
// Realiza operações de acesso a dados referente a Pagamento.
@Repository
// JpaRepository<ClasseModelo, ChavePrimariaDaClasseModelo>
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
