package org.fife.jt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class OneToOneChild {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Parent parent;

    @Column(name = "val", nullable = false)
    private int value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
