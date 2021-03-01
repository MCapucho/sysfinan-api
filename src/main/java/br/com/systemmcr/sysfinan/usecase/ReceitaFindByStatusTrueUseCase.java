package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;

import java.util.List;

public interface ReceitaFindByStatusTrueUseCase {

    List<ReceitaEntity> findByStatusTrue();
}
