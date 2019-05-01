package br.com.touchapps.pontoeletronico.services;

import br.com.touchapps.pontoeletronico.entities.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

/**
 * Interface responsável em centralizar os métodos de acesso e manipualação
 * de dados com a camada de Repository para a entidade Lancamentos.
 *
 * @author Lucas Araújo
 * @version 1.0
 */
public interface LancamentosService {

    /**
     * Retorna uma lista paginada de lançamentos de um determinado funcionário.
     *
     * @param funcionarioId
     * @param pageRequest
     * @return Page<Lancamento>
     */
    Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);

    /**
     * Retorna um lançamento por ID.
     *
     * @param id
     * @return Optional<Lancamento>
     */
    Optional<Lancamento> buscarPorId(Long id);

    /**
     * Persiste um lançamento na base de dados.
     *
     * @param lancamento
     * @return Lancamento
     */
    Lancamento persistir(Lancamento lancamento);

    /**
     * Remove um lançamento da base de dados.
     *
     * @param id
     */
    void remover(Long id);

}
