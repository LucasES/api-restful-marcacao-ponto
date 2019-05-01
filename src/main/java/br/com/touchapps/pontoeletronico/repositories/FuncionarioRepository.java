package br.com.touchapps.pontoeletronico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.touchapps.pontoeletronico.api.entities.Funcionario;

/**
 * Interface responsável em realizar consultas e acessos no banco de dados na tabela de funcionario.
 *
 * @author Lucas Araújo
 * @version 1.0
 */
@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findByCpf(String cpf);
	
	Funcionario findByEmail(String email);
	
	Funcionario findByCpfOrEmail(String cpf, String email);
}
