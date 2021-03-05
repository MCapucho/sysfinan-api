package br.com.systemmcr.sysfinan.adapter.mapper;

import br.com.systemmcr.sysfinan.adapter.model.ReceitaHTTP;
import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.util.FromToMapper;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReceitaHttpMapper extends FromToMapper<ReceitaHTTP, ReceitaEntity> {

    @Override
    protected ReceitaHTTP fromNonNull(ReceitaEntity receitaEntity) {
        ReceitaHTTP receitaHTTP = new ReceitaHTTP();
        receitaHTTP.setCodigo(receitaEntity.getCodigo());
        receitaHTTP.setDescricao(receitaEntity.getDescricao());
        receitaHTTP.setAtivo(receitaEntity.getAtivo());
        return receitaHTTP;
    }

    @Override
    protected ReceitaEntity toNonNull(ReceitaHTTP receitaHTTP) {
        ReceitaEntity receitaEntity = new ReceitaEntity();
        receitaEntity.setCodigo(receitaHTTP.getCodigo());
        receitaEntity.setDescricao(receitaHTTP.getDescricao());
        receitaEntity.setAtivo(receitaHTTP.getAtivo());
        return receitaEntity;
    }
}
