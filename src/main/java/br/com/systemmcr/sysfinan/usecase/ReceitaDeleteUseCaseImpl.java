package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.port.ReceitaPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ReceitaDeleteUseCaseImpl implements ReceitaDeleteUseCase {

    @Inject
    ReceitaPort receitaPort;

    @Inject
    ReceitaFindByIdUseCase receitaFindByIdUseCase;

    @Override
    public void deleteById(Long codigo) {
        ReceitaEntity receitaEntity = receitaFindByIdUseCase.findById(codigo);

        if (receitaEntity != null) {
            receitaPort.deleteById(codigo);
        }
    }
}
