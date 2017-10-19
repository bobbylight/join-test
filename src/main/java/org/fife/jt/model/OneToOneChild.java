package org.fife.jt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.fife.jt.ModelConstants;

import javax.persistence.*;

@Entity
public class OneToOneChild {

    @Id
    @Column(name = "id", updatable = false)
    private long id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = false)
    private Parent parent;

    @Column(name = "name", length = ModelConstants.COLUMN_LENGTH_SHORT)
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
