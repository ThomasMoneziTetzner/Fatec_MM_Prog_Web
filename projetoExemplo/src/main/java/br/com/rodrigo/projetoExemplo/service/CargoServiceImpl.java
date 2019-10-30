package br.com.rodrigo.projetoExemplo.service;

import br.com.rodrigo.projetoExemplo.dao.CargoDao;
import br.com.rodrigo.projetoExemplo.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// indicando que essa classe vai ser gerenciada pelo container do Spring
// classe que representa fluxo de negócio da aplicação
@Service
//readOnly, vai informar ao Spring que a transação não é apenas de leitura, ou seja, ela deve
// ser usada tanto em métodos de consulta como de escrita
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {
    //informa ao Spring que ele deve injetar a variável anotada
    @Autowired
    private CargoDao dao;
    @Override
    public void salvar(Cargo cargo) {
        dao.save(cargo);
    }
    @Override
    public void editar(Cargo cargo) {
        dao.update(cargo);
    }
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }
    //informa ao Spring que a transação é apenas de leitura, ou seja, ela deve ser
    // usada só em métodos de consulta
    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {

        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {

        return dao.findAll();
    }
}

