package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.exception.DadosDuplicadosException;
import br.com.systemmcr.sysfinan.port.ReceitaPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ReceitaUpdateUseCaseImpl implements ReceitaUpdateUseCase {

    @Inject
    ReceitaPort receitaPort;

    @Inject
    ReceitaFindByIdUseCase receitaFindByIdUseCase;

    @Override
    public ReceitaEntity update(Long id, ReceitaEntity receitaEntity) {
        ReceitaEntity receitaEntityFound = receitaPort.findByDescricao(receitaEntity.getDescricao());

        if (receitaEntityFound != null) {
            throw new DadosDuplicadosException("A receita " + receitaEntityFound.getDescricao() +
                    " já se encontra cadastrada!");
        }

        receitaEntityFound = receitaFindByIdUseCase.findById(id);

        if (receitaEntityFound != null) {
            receitaEntity.setCodigo(receitaEntityFound.getCodigo());
            receitaEntityFound = receitaPort.createOrUpdate(receitaEntity);
        }

        return receitaEntityFound;
    }
}
