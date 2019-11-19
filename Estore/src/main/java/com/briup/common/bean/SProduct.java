package com.briup.common.bean;

import java.io.Serializable;

public class SProduct implements Serializable {
    private Long id;

    private String name;

    private Long price;

    private String publish;

    private String img;

    private Long hot;

    private Long remain;

    private Long sellnum;

    private Long clickrate;

    private Long publishdate;

    private Long cateDetailId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish == null ? null : publish.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Long getHot() {
        return hot;
    }

    public void setHot(Long hot) {
        this.hot = hot;
    }

    public Long getRemain() {
        return remain;
    }

    public void setRemain(Long remain) {
        this.remain = remain;
    }

    public Long getSellnum() {
        return sellnum;
    }

    public void setSellnum(Long sellnum) {
        this.sellnum = sellnum;
    }

    public Long getClickrate() {
        return clickrate;
    }

    public void setClickrate(Long clickrate) {
        this.clickrate = clickrate;
    }

    public Long getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Long publishdate) {
        this.publishdate = publishdate;
    }

    public Long getCateDetailId() {
        return cateDetailId;
    }

    public void setCateDetailId(Long cateDetailId) {
        this.cateDetailId = cateDetailId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", publish=").append(publish);
        sb.append(", img=").append(img);
        sb.append(", hot=").append(hot);
        sb.append(", remain=").append(remain);
        sb.append(", sellnum=").append(sellnum);
        sb.append(", clickrate=").append(clickrate);
        sb.append(", publishdate=").append(publishdate);
        sb.append(", cateDetailId=").append(cateDetailId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}