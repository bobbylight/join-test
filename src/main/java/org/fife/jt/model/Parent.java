package org.fife.jt.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;

/**
 * An entity with various types of child entities.
 */
@Entity
public class Parent {

    @Id
    @Column(name = "id", updatable = false)
    private long id;

    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference
    private OneToOneChild oneToOneChild;

    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference
    private OneToOneChild2 oneToOneChild2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", id)
            .append("oneToOneChild", oneToOneChild != null)
            .toString();
    }
}
