package br.com.touchapps.pontoeletronico.services;

import br.com.touchapps.pontoeletronico.entities.Empresa;

import java.util.Optional;

/**
 * Interface responsável em centralizar os métodos de acesso e manipualação
 * de dados com a camada de Repository para a entidade Empresa.
 *
 * @author Lucas Araújo
 * @version 1.0
 */
public interface EmpresaService {

    /**
     * Este método tem como objetivo buscar uma empresa por CNPJ.
     *
     * @param cnpj
     *
     * @return Empresa
     */
    Optional<Empresa> buscarPorCNPJ(String cnpj);


    /**
     * Este método tem como objetivo persistir uma empresa.
     *
     * @param empresa
     *
     * @return Empresa persistida.
     */
    Empresa save(Empresa empresa);
}
