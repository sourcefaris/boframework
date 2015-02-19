package org.bo.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Name implements Serializable {
    private String prefix;
    private String first;
    private String middle;
    private String last;

    @Transient
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * @hibernate.property column="first_name" length="128"
     */
    @Column(name="first_name")
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Transient
    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    /**
     * @hibernate.property column="last_name" length="128"
     */
    @Column(name="last_name")
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
