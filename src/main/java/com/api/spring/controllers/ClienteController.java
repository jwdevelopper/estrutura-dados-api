package com.api.spring.controllers;

import com.api.spring.entidades.Cliente;
import com.api.spring.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//DISPONIBILIZA A CLASSE JUNTAMENTE COM SEUS ENDPOINTS PARA SEREM CONSUMIDAS ATRAVÉS DE REQUISIÇÕES
// HTTP(REST)
@RestController
//DEFINI O ALIAS PARA O ENDPOINT EXEMPLO localhost:8080/clientes.....
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;


    //POST -> RESPONSAVEL POR ENVIAR INFORMACOES VIA JSON PELO CORPO(BODY) DA REQUISICAO
    @PostMapping("/salvar-cliente")
    //REQUEST BODY -> DEFINE O TIPO DE INFORMAÇÃO HA SER ENVIADO NO CORPO DA REQUISICAO
    public Cliente salvar(@RequestBody Cliente cliente) {

        return clienteService.salvarCliente(cliente);
    }

    //GET -> RESPONSAVEL POR RETORNAR INFORMAÇÕES PARA REQUISIÇÃO VIA JSON
    // RETORNA UMA LISTA DE CLIENTES
    @GetMapping("/listar-clientes")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/buscar-cliente/{id}")
    //PATH VARIABLE -> REFERENCIA O PARAMETRO QUE VEM VIA REQUISICAO
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    //PROPRIEDADE REST QUE INDICA QUE A CHAMADA REFERENCIA UM PROCESSO DE DELETAR
    //UM CLIENTE
    @DeleteMapping("/deletar-cliente/{id}")
    public void deletarClientePorId(@PathVariable Long id) {
        clienteService.deletarClientePorId(id);
    }


    //PROPRIEDADE SEMELHANTE AO POST PORÉM É UTILIZADO PARA ATUALIZAR INFORMAÇÕES E NÃO
    // INSERI-LAS
    @PutMapping("/atualizar-cliente/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarClientePorId(id, cliente);
    }

}
