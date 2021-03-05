package br.com.systemmcr.sysfinan.adapter.resource;

import br.com.systemmcr.sysfinan.adapter.mapper.ReceitaHttpMapper;
import br.com.systemmcr.sysfinan.adapter.model.ReceitaHTTP;
import br.com.systemmcr.sysfinan.entity.ReceitaEntity;
import br.com.systemmcr.sysfinan.usecase.*;

import javax.inject.Inject;
import javax.validation.Valid;
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
    @Inject
    ReceitaCreateUseCase receitaCreateUseCase;
    @Inject
    ReceitaUpdateUseCase receitaUpdateUseCase;
    @Inject
    ReceitaDeleteUseCase receitaDeleteUseCase;

    @GET
    public List<ReceitaHTTP> findAll() {
        List<ReceitaEntity> listaReceita = receitaFindAllUseCase.findAll();
        return mapper.fromList(listaReceita);
    }

    @GET
    @Path("/{codigo}")
    public Response findById(@PathParam("codigo") Long id) {
        ReceitaEntity receitaEntity = receitaFindByIdUseCase.findById(id);
        return Response.status(Response.Status.OK).entity(mapper.from(receitaEntity)).build();
    }

    @GET
    @Path("/status/true")
    public List<ReceitaHTTP> findByStatusTrue() {
        List<ReceitaEntity> listaReceita = receitaFindByStatusTrueUseCase.findByStatusTrue();
        return mapper.fromList(listaReceita);
    }

    @POST
    public Response create(@Valid ReceitaHTTP receitaHTTP) {
        ReceitaEntity receitaEntity = receitaCreateUseCase.create(mapper.to(receitaHTTP));
        return Response.status(Response.Status.CREATED).entity(mapper.from(receitaEntity)).build();
    }

    @PUT
    @Path("/{codigo}")
    public Response update(@PathParam("codigo") Long id, ReceitaHTTP receitaHTTP) {
        ReceitaEntity receitaEntity = receitaUpdateUseCase.update(id, mapper.to(receitaHTTP));
        return Response.status(Response.Status.OK).entity(mapper.from(receitaEntity)).build();
    }

    @DELETE
    @Path("/{codigo}")
    public Response delete(@PathParam("codigo") Long id) {
        receitaDeleteUseCase.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
