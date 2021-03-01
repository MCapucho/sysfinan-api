package br.com.systemmcr.sysfinan.util;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public abstract class FromToMapper<T, E> extends ToMapper<T, E> {

    protected final T NULL_NOT_CORE_ENTITY = null;

    public T from(E outerEntity) {
        return Optional.ofNullable(outerEntity).map(this::fromNonNull).orElse(NULL_NOT_CORE_ENTITY);
    }

    protected abstract T fromNonNull(E entity);

    public List<T> fromList(List<E> outerEntities) {
        return Optional.ofNullable(outerEntities).map(this::fromListNonNull).orElse(Collections.emptyList());
    }

    private List<T> fromListNonNull(List<E> outerEntities) {
        return outerEntities.stream().map(this::from).collect(Collectors.toList());
    }
}
