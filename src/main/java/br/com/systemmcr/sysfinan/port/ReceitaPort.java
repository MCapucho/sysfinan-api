package br.com.systemmcr.sysfinan.port;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;

import java.util.List;

public interface ReceitaPort {

    List<ReceitaEntity> findAll();
    List<ReceitaEntity> findByStatusTrue();
    ReceitaEntity findById(Long codigo);
}
