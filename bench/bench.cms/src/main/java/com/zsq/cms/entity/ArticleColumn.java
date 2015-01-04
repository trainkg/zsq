package com.zsq.cms.entity;

import java.util.Date;

public class ArticleColumn {
    private String id;

    private String code;

    private String name;

    private Short status;

    private Date createDate;

    private String pCId;

    private String columntypeid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getpCId() {
        return pCId;
    }

    public void setpCId(String pCId) {
        this.pCId = pCId;
    }

    public String getColumntypeid() {
        return columntypeid;
    }

    public void setColumntypeid(String columntypeid) {
        this.columntypeid = columntypeid;
    }
}