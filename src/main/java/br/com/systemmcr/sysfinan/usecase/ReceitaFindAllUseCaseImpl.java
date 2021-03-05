package br.com.systemmcr.sysfinan.usecase;

import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.port.ReceitaPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ReceitaFindAllUseCaseImpl implements ReceitaFindAllUseCase {

    public static Logger logger = LoggerFactory.getLogger(ReceitaFindAllUseCaseImpl.class);

    @Inject
    ReceitaPort receitaPort;

    @Override
    public List<ReceitaEntity> findAll() {
        List<ReceitaEntity> listaReceita = receitaPort.findAll();

        if (listaReceita.size() == 0) {
            logger.info("A lista de receita está vazia!");
        }

        return listaReceita;
    }
}
