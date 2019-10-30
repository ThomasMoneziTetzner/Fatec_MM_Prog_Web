package br.com.rodrigo.projetoExemplo.service;

import br.com.rodrigo.projetoExemplo.dao.DepartamentoDao;
import br.com.rodrigo.projetoExemplo.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// indicando que essa classe vai ser gerenciada pelo container do Spring
// classe que representa fluxo de negócio da aplicação
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    //informa ao Spring que ele deve injetar a variável anotada
    @Autowired
    private DepartamentoDao dao;

    //readOnly, vai informar ao Spring que a transação não é apenas de leitura, ou seja, ela deve ser usada tanto em métodos de consulta como de escrita
    @Transactional(readOnly = false)
    @Override
    public void salvar(Departamento departamento) {
        dao.save(departamento);
    }

    @Transactional(readOnly = false)
    @Override
    public void editar(Departamento departamento) {
        dao.update(departamento);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Departamento buscarPorId(Long id) {

        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Departamento> buscarTodos() {

        return dao.findAll();
    }

    @Override
    public boolean depertamentoTemCargos(Long id) {
        if (buscarPorId(id).getCargos().isEmpty()) {
            return false;
        }
        return true;
    }

}

