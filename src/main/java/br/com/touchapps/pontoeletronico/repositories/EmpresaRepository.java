package br.com.touchapps.pontoeletronico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.touchapps.pontoeletronico.api.entities.Empresa;

/**
 * Interface responsável em realizar consultas e acessos no banco de dados na tabela de empresa.
 *
 * @author Lucas Araújo
 * @version 1.0
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	Empresa findByCnpj(String cnpj);
}