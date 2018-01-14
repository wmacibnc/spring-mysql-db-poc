package spring.mysql.poc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spring.mysql.poc.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	/**
	 * Método responsável por consultar uma pessoa por nome.
	 * 
	 * @param nome
	 * @return
	 */
	Pessoa findByNome(String nome);

	/**
	 * Método responsável por consultar todas as pessoas com o mesmo E-mail
	 * 
	 * @param email
	 * @return
	 */
	List<Pessoa> findByEmail(String email);
}
