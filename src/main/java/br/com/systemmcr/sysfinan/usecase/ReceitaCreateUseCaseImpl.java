package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.exception.DadosDuplicadosException;
import br.com.systemmcr.sysfinan.port.ReceitaPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ReceitaCreateUseCaseImpl implements ReceitaCreateUseCase {

    @Inject
    ReceitaPort receitaPort;

    @Override
    public ReceitaEntity create(ReceitaEntity receitaEntity) {
        ReceitaEntity receitaEntityFound = receitaPort.findByDescricao(receitaEntity.getDescricao());

        if (receitaEntityFound == null) {
            return receitaPort.createOrUpdate(receitaEntity);
        } else {
            throw new DadosDuplicadosException("A receita " + receitaEntityFound.getDescricao() +
                    " já se encontra cadastrada!");
        }
    }
}
