package br.com.touchapps.pontoeletronico.services;

import br.com.touchapps.pontoeletronico.entities.Funcionario;

import java.util.Optional;

/**
 * Interface responsável em centralizar os métodos de acesso e manipualação
 * de dados com a camada de Repository para a entidade Funcionario.
 *
 * @author Lucas Araújo
 * @version 1.0
 */
public interface FuncionarioService {

    /**
     * Este método tem como objetivo persistir um funcionario.
     *
     * @param funcionario
     *
     * @return Funcionario persistid2.
     */

    Funcionario salvar(Funcionario funcionario);

    /**
     * Este método tem como objetivo buscar um funcionario por CPF.
     *
     * @param cpf
     *
     * @return Optional<Funcionario>
     */
    Optional<Funcionario> buscarPorCPF(String cpf);

    /**
     * Este método tem como objetivo buscar um funcionario por e-mail.
     *
     * @param email
     *
     * @return Optional<Funcionario>
     */
    Optional<Funcionario> buscarPorEmail(String email);

    /**
     * Este método tem como objetivo buscar um funcionario por id.
     *
     * @param id
     *
     * @return Optional<Funcionario>
     */
    Optional<Funcionario> buscarPorId(Long id);
}
