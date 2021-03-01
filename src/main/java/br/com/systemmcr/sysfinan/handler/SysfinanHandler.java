package br.com.systemmcr.sysfinan.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SysfinanHandler implements ExceptionMapper<Exception> {

    private static Logger logger = LoggerFactory.getLogger(SysfinanHandler.class);

    @Override
    public Response toResponse(Exception e) {
        logger.info("Exception: " + e.getMessage());
        return Response.status(Response.Status.OK).entity(e.getMessage()).build();
    }
}
