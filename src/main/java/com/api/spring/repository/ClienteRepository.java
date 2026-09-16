package com.api.spring.repository;

import com.api.spring.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    CLASSE RESPONSAVEL POR SE COMUNICAR COM NOSSO BANCO DE DADOS.
    É NECESSARIO EXTENDER A CLASSE DO JPA DE NOME JpaRepository
    JpaRepository ELE É RESPONSAVEL POR REALIZAR A CONEXAO COM O BANCO DE DADOS
    E TAMBEM POSSUI OS METODO BASICOS PRONTOS DE UM CRUD
    JpaRepository<Cliente, Long> -> PRIMEIRO PARAMETRO O OBJETO QUE DEVE SER PERSISTIDO
    NO BANCO DE DADOS, SEGUNDO PARAMETRO TIPO DO ID A SER MANIPULADO
    O TIPO DO ID DEVE SER INFORMADO POIS É ATRAVÉS DESSE TIPO QUE OPERAÇÕES COMO BUSCAR POR ID
    OU DELETAR POR ID CONSEGUEM FAZER VERIFICAÇÃO DE TIPAGEM DO ATRIBUTO E CONSEQUENTEMENTE A BUSCA
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
