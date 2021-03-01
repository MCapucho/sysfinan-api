package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.exception.ResourceNotFoundException;
import br.com.systemmcr.sysfinan.port.ReceitaPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ReceitaFindByIdUseCaseImpl implements ReceitaFindByIdUseCase {

    @Inject
    ReceitaPort receitaPort;

    @Override
    public ReceitaEntity findById(Long codigo) {
        ReceitaEntity receitaEntity = receitaPort.findById(codigo);

        if (receitaEntity == null) {
            throw new ResourceNotFoundException("A receita com o código " + codigo + " não foi encontrada!");
        }

        return receitaEntity;
    }
}
