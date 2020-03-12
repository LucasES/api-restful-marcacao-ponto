package br.com.touchapps.pontoeletronico.repositories;

import br.com.touchapps.pontoeletronico.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface responsável em realizar consultas e acessos no banco de dados na tabela de empresa.
 *
 * @author Lucas Araújo
 * @version 1.0
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);

}