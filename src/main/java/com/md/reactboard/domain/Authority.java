package com.md.reactboard.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Authority extends AbstractEntity implements GrantedAuthority {

    /**
     *
     */
    private static final long serialVersionUID = 7190787175352450609L;

    @Column(name = "pname", nullable = false, unique = true, length = 50)
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getAuthority() {
        return this.name;
    }
}
