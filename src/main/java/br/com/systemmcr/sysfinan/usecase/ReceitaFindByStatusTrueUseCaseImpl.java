package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.exception.ListaVaziaException;
import br.com.systemmcr.sysfinan.port.ReceitaPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ReceitaFindByStatusTrueUseCaseImpl implements ReceitaFindByStatusTrueUseCase {

    @Inject
    ReceitaPort receitaPort;

    @Override
    public List<ReceitaEntity> findByStatusTrue() {
        List<ReceitaEntity> listaReceita = receitaPort.findByStatusTrue();

        if (listaReceita.size() == 0) {
            throw new ListaVaziaException("A lista de receita está vazia!");
        }

        return listaReceita;
    }
}
