package com.cy.store.vo;

import java.io.Serializable;
import java.util.Objects;

public class LoveVo implements Serializable {
    private Integer lid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private String title;
    private String image;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoveVo loveVo = (LoveVo) o;
        return Objects.equals(lid, loveVo.lid) && Objects.equals(uid, loveVo.uid) && Objects.equals(pid, loveVo.pid) && Objects.equals(price, loveVo.price) && Objects.equals(title, loveVo.title) && Objects.equals(image, loveVo.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lid, uid, pid, price, title, image);
    }

    @Override
    public String toString() {
        return "LoveVo{" +
                "lid=" + lid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
