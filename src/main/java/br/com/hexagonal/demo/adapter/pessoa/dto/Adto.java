package br.com.hexagonal.demo.adapter.pessoa.dto;

abstract class Adto<I> {
    private I id;

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
