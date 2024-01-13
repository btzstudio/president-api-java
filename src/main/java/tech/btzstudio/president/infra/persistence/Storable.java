package tech.btzstudio.president.infra.persistence;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface Storable<T, PK> {
    CompletableFuture<Optional<T>> findById(PK id);
    CompletableFuture<T> save(T object);
    CompletableFuture<Void> remove(PK id);

    CompletableFuture<Collection<T>> findAll();
}
