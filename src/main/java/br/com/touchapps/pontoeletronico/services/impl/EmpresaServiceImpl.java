package br.com.touchapps.pontoeletronico.services.impl;

import br.com.touchapps.pontoeletronico.entities.Empresa;
import br.com.touchapps.pontoeletronico.repositories.EmpresaRepository;
import br.com.touchapps.pontoeletronico.services.EmpresaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe que implementa as operações de serviço para Empresa
 *
 * @author Lucas Araújo
 * @version 1.0
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> buscarPorCNPJ(String cnpj) {
        logger.info("Buscando empresa por CNPJ com valor: " + cnpj);
        Empresa byCnpj = this.empresaRepository.findByCnpj(cnpj);

        return Optional.ofNullable(byCnpj);
    }

    @Override
    public Empresa salvar(Empresa empresa) {
        logger.info("Persistindo empresa: " + empresa);

        return this.empresaRepository.save(empresa);
    }
}
