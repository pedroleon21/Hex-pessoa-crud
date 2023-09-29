package br.com.hexagonal.demo.adapter.mapper;

public interface Mapper<E, D> {
    public D toDto(E entity);

    public E toEntity(D dto);
}
