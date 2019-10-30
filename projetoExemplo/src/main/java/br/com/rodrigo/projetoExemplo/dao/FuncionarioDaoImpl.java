package br.com.rodrigo.projetoExemplo.dao;

import br.com.rodrigo.projetoExemplo.domain.Funcionario;
import org.springframework.stereotype.Repository;

// transformando a classe em um bean do Spring
@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}

