package com.cy.store.entity;

import java.io.Serializable;
import java.util.Objects;

public class Love extends BaseEntity implements Serializable {
    private Integer lid;
    private Integer uid;
    private Integer pid;
    private Long price;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Love{" +
                "lid=" + lid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Love love = (Love) o;
        return Objects.equals(lid, love.lid) && Objects.equals(uid, love.uid) && Objects.equals(pid, love.pid) && Objects.equals(price, love.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lid, uid, pid, price);
    }
}
