package com.wewash.services.domain.ebet.dto.betmarket;

import org.apache.commons.lang.builder.EqualsBuilder;

public class BetMarketTypeDTO {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BetMarketTypeDTO that = (BetMarketTypeDTO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public String toString() {
        return "BetMarketTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}