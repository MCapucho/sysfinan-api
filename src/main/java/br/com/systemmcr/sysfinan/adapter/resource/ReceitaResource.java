package br.com.systemmcr.sysfinan.adapter.resource;

import br.com.systemmcr.sysfinan.adapter.mapper.ReceitaHttpMapper;
import br.com.systemmcr.sysfinan.adapter.model.ReceitaHTTP;
import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.usecase.ReceitaFindAllUseCase;
import br.com.systemmcr.sysfinan.usecase.ReceitaFindByIdUseCase;
import br.com.systemmcr.sysfinan.usecase.ReceitaFindByStatusTrueUseCase;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/receitas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReceitaResource {

    @Inject
    ReceitaHttpMapper mapper;

    @Inject
    ReceitaFindAllUseCase receitaFindAllUseCase;
    @Inject
    ReceitaFindByStatusTrueUseCase receitaFindByStatusTrueUseCase;
    @Inject
    ReceitaFindByIdUseCase receitaFindByIdUseCase;

    @GET
    public List<ReceitaHTTP> findAll() {
        List<ReceitaEntity> listaReceita = receitaFindAllUseCase.findAll();
        return mapper.fromList(listaReceita);
    }

    @GET
    @Path("/status/true")
    public List<ReceitaHTTP> findByStatusTrue() {
        List<ReceitaEntity> listaReceita = receitaFindByStatusTrueUseCase.findByStatusTrue();
        return mapper.fromList(listaReceita);
    }

    @GET
    @Path("/{codigo}")
    public Response findById(@PathParam("codigo") Long id) {
        ReceitaEntity receitaEntity = receitaFindByIdUseCase.findById(id);
        return Response.status(Response.Status.OK).entity(mapper.from(receitaEntity)).build();
    }
}
