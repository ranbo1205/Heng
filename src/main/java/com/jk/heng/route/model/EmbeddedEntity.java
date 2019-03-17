package com.jk.heng.route.model;

public class EmbeddedEntity<T> {

    T embedded;

    public EmbeddedEntity(T listEmbeddedEntity) {
        embedded = listEmbeddedEntity;
    }

    public T getEmbedded() {
        return embedded;
    }

    public void setEmbedded(T embedded) {
        this.embedded = embedded;
    }
}
