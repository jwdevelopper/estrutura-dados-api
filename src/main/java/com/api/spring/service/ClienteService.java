package com.api.spring.service;

import com.api.spring.entidades.Cliente;
import com.api.spring.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    A ANOTATION @Service IDENTIFICA QUE A CLASSE SE TRATA DE UM SERVICE
    O SERVICE É RESPONSAVEL POR RECEBER AS REQUISIÇÕES DO CONTROLLER E FAZER A COMUNICAÇÃO COM O REPOSITORY
    A ANOTACAO TORNA A CLASSE GERENCIAVEL PELO SPRING BOOT O QUE A TORNA POSSIVEL FAZER A INJECAO DELA
    EM OUTROS CONTEXTOS
 */
@Service
@RequiredArgsConstructor //injeta a dependencia de forma automatica
public class ClienteService {

    private final ClienteRepository clienteRepository;

/* METODO HARDCODED PARA INJECAO DE DEPENCIA NO CASO CLIENTE REPOSITORY
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

 */

    public Cliente salvarCliente(Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo;
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente buscarClientePorId(Long id) {
        /*
       FINDBYID PODE OU NÃO RETORNAR UM OBJETO POIS O ID PODE OU NAO EXISTIR EM NOSSO BANCO DE DADOS
       CASO O ID NÃO EXISTA, SERA EXECUTADO O ORELSETHROW RESPONSAVEL POR LANCAR O ERRO DE CLIENTE NÃO ENCONTRADO
        * */
        Cliente cliente = clienteRepository.findById(id).
                orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado!"));
        return cliente;
    }

    public void deletarClientePorId(Long id) {
        try {
            clienteRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar cliente enviado");
        }
    }

    public Cliente atualizarClientePorId(Long id, Cliente cliente) {
        Cliente clienteSalvo = buscarClientePorId(id);
        BeanUtils.copyProperties(cliente, clienteSalvo, "id");
        return clienteRepository.save(clienteSalvo);
    }
}
