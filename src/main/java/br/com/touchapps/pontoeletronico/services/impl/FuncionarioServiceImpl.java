package br.com.touchapps.pontoeletronico.services.impl;


import br.com.touchapps.pontoeletronico.entities.Funcionario;
import br.com.touchapps.pontoeletronico.repositories.FuncionarioRepository;
import br.com.touchapps.pontoeletronico.services.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe que implementa as operações de serviço para Funcionario
 *
 * @author Lucas Araújo
 * @version 1.0
 */
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private static final Logger logger = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        logger.info("Persistindo um funcionário: " + funcionario);

        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> buscarPorCPF(String cpf) {
        logger.info("Buscando um funcionário com CPF: " + cpf);

        return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Funcionario> buscarPorEmail(String email) {
        logger.info("Buscando um funcionário com e-mail: " + email);

        return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        logger.info("Buscando um funcionário com id: " + id);

        return this.funcionarioRepository.findById(id);
    }
}
