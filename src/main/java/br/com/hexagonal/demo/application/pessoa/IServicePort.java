package br.com.hexagonal.demo.application.pessoa;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServicePort<E, I> {
    public E get(I id);

    public void delete(I id);

    public E create(E entity);

    public List<E> list(Pageable pageable);
}
