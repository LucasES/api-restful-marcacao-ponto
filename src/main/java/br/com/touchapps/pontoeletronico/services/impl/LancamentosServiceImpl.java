package br.com.touchapps.pontoeletronico.services.impl;

import br.com.touchapps.pontoeletronico.entities.Lancamento;
import br.com.touchapps.pontoeletronico.repositories.LancamentoRepository;
import br.com.touchapps.pontoeletronico.services.LancamentosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe que implementa as operações de serviço para Lancamentos.
 *
 * @author Lucas Araújo
 * @version 1.0
 */
@Service
public class LancamentosServiceImpl implements LancamentosService {

    private static final Logger log = LoggerFactory.getLogger(LancamentosServiceImpl.class);

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        log.info("Buscando lançamentos para o funcionário ID {}", funcionarioId);
        return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
    }

    @Cacheable("lancamentoPorId")
    public Optional<Lancamento> buscarPorId(Long id) {
        log.info("Buscando um lançamento pelo ID {}", id);
        return this.lancamentoRepository.findById(id);
    }

    @CachePut("lancamentoPorId")
    public Lancamento persistir(Lancamento lancamento) {
        log.info("Persistindo o lançamento: {}", lancamento);
        return this.lancamentoRepository.save(lancamento);
    }

    public void remover(Long id) {
        log.info("Removendo o lançamento ID {}", id);
        this.lancamentoRepository.deleteById(id);
    }
}