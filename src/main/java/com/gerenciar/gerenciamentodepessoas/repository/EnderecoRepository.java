package com.gerenciar.gerenciamentodepessoas.repository;

import com.gerenciar.gerenciamentodepessoas.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}
