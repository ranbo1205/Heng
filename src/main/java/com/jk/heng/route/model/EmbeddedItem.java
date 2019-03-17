package com.jk.heng.route.model;

public class EmbeddedItem<T> {

    T embedded;

    public EmbeddedItem (T embedded){
        this.embedded = embedded;
    }

    public T getEmbedded() {
        return embedded;
    }

    public void setEmbedded(T embedded) {
        this.embedded = embedded;
    }
}
