package br.com.hexagonal.demo.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
abstract class AEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;

    public AEntity() {
    }

    public AEntity(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
