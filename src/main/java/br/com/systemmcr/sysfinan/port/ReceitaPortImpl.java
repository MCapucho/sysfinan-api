package br.com.systemmcr.sysfinan.port;

import br.com.systemmcr.sysfinan.adapter.database.entity.ReceitaDB;
import br.com.systemmcr.sysfinan.adapter.database.repository.ReceitaRepository;
import br.com.systemmcr.sysfinan.adapter.mapper.ReceitaDBMapper;
import br.com.systemmcr.sysfinan.entity.ReceitaEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ReceitaPortImpl implements ReceitaPort {

    @Inject
    ReceitaDBMapper mapper;
    @Inject
    ReceitaRepository repository;

    @Override
    public List<ReceitaEntity> findAll() {
        List<ReceitaDB> listaReceita = ReceitaDB.listAll();
        return mapper.toList(listaReceita);
    }

    @Override
    public List<ReceitaEntity> findByStatusTrue() {
        List<ReceitaDB> listaReceita = repository.listAllStatus();
        return mapper.toList(listaReceita);
    }

    @Override
    public ReceitaEntity findById(Long codigo) {
        ReceitaDB receitaDB = ReceitaDB.findById(codigo);
        return mapper.to(receitaDB);
    }

    @Override
    public ReceitaEntity findByDescricao(String descricao) {
        ReceitaDB receitaDB = repository.findByDescricao(descricao);
        return mapper.to(receitaDB);
    }

    @Override
    public ReceitaEntity createOrUpdate(ReceitaEntity receitaEntity) {
        ReceitaDB receitaDB = repository.createOrUpdate(mapper.from(receitaEntity));
        return mapper.to(receitaDB);
    }

    @Override
    public void deleteById(Long codigo) {
        repository.delete(codigo);
    }
}
