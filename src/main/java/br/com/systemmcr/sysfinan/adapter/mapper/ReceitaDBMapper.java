package br.com.systemmcr.sysfinan.adapter.mapper;

import br.com.systemmcr.sysfinan.adapter.database.entity.ReceitaDB;
import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.util.FromToMapper;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReceitaDBMapper extends FromToMapper<ReceitaDB, ReceitaEntity> {

    @Override
    protected ReceitaDB fromNonNull(ReceitaEntity receitaEntity) {
        ReceitaDB receitaDB = new ReceitaDB();
        receitaDB.setCodigo(receitaEntity.getCodigo());
        receitaDB.setDescricao(receitaEntity.getDescricao());
        receitaDB.setAtivo(receitaEntity.getAtivo());
        return receitaDB;
    }

    @Override
    protected ReceitaEntity toNonNull(ReceitaDB receitaDB) {
        ReceitaEntity receitaEntity = new ReceitaEntity();
        receitaEntity.setCodigo(receitaDB.getCodigo());
        receitaEntity.setDescricao(receitaDB.getDescricao());
        receitaEntity.setAtivo(receitaDB.getAtivo());
        return receitaEntity;
    }
}
