package br.com.systemmcr.sysfinan.adapter.database.repository;

import br.com.systemmcr.sysfinan.adapter.database.entity.ReceitaDB;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ReceitaRepository implements PanacheRepository<ReceitaDB> {

    public List<ReceitaDB> listAllStatus() {
        return list("ativo", true);
    }

}
