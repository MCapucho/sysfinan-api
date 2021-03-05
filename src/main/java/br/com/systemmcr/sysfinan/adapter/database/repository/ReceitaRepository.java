package br.com.systemmcr.sysfinan.adapter.database.repository;

import br.com.systemmcr.sysfinan.adapter.database.entity.ReceitaDB;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ReceitaRepository implements PanacheRepository<ReceitaDB> {

    public List<ReceitaDB> listAllStatus() {
        return list("ativo", true);
    }

    public ReceitaDB findByDescricao(String descricao) {
        return find("descricao", descricao).firstResult();
    }

    @Transactional
    public ReceitaDB createOrUpdate(ReceitaDB receitaDB) {
        if (receitaDB.getCodigo() != null) {
            ReceitaDB receitaDBFound = findById(receitaDB.getCodigo());
            receitaDBFound.setDescricao(
                    receitaDB.getDescricao() != null ? receitaDB.getDescricao() : receitaDBFound.getDescricao());
            receitaDBFound.setAtivo(
                    receitaDB.getAtivo() != null ? receitaDB.getAtivo() : receitaDBFound.getAtivo());
            receitaDBFound.persist();
            return receitaDBFound;
        } else {
            receitaDB.persist();
            return receitaDB;
        }
    }

    @Transactional
    public void delete(Long codigo) {
        ReceitaDB receitaDB = findById(codigo);
        receitaDB.delete();
    }
}
