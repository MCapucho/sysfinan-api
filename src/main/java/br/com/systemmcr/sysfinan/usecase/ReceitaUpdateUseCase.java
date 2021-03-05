package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;

public interface ReceitaUpdateUseCase {

    ReceitaEntity update(Long id, ReceitaEntity receitaEntity);
}
