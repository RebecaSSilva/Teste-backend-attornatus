package com.gerenciar.gerenciamentodepessoas.repository;

import com.gerenciar.gerenciamentodepessoas.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    public Optional<PessoaModel> findByNome(String nome);
    public List<PessoaModel> findAllByNomeContainingIgnoreCase(String nome);
}
