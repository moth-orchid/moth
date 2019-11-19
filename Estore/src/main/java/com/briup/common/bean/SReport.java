package com.briup.common.bean;

import java.io.Serializable;
import java.util.Date;

public class SReport implements Serializable {
    private Long id;

    private String name;

    private Long rankaaa;

    private Date publishDate;

    private String department;

    private String publishWriter;

    private String content;

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

    public Long getRankaaa() {
        return rankaaa;
    }

    public void setRankaaa(Long rankaaa) {
        this.rankaaa = rankaaa;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPublishWriter() {
        return publishWriter;
    }

    public void setPublishWriter(String publishWriter) {
        this.publishWriter = publishWriter == null ? null : publishWriter.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", rankaaa=").append(rankaaa);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", department=").append(department);
        sb.append(", publishWriter=").append(publishWriter);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}