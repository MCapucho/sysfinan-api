package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;

public interface ReceitaFindByIdUseCase {

    ReceitaEntity findById(Long codigo);
}
