package org.fife.jt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class OneToOneChild2 {

    @Id
    @Column(name = "id", updatable = false)
    private long id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = false)
    private Parent parent;

    @Column(name = "name", length = 30)
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
