package com.shop.advance.academy.yordan.petrov.git.shop.domain.dto;

import java.util.Objects;

/**
 * Class dto for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
public class RoleServiceModel {

    private Long id;
    private String authority;

    /**
     * Constructor
     */
    public RoleServiceModel() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets authority.
     *
     * @return the authority
     */
    public String getAuthority() {
        return this.authority;
    }

    /**
     * Sets authority.
     *
     * @param authority the authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleServiceModel)) return false;
        RoleServiceModel that = (RoleServiceModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authority);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoleServiceModel{");
        sb.append("id=").append(id);
        sb.append(", authority='").append(authority).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
