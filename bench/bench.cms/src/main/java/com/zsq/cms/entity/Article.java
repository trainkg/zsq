package com.zsq.cms.entity;

import java.util.Date;

public class Article {
    private String id;

    private String title;

    private String smtitle;

    private String digest;

    private Date createDate;

    private Date modifyDate;

    private String creatname;

    private String modifyname;

    private String creategroupname;

    private String modifygroupname;

    private String creator;

    private String modifier;

    private String keyward;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSmtitle() {
        return smtitle;
    }

    public void setSmtitle(String smtitle) {
        this.smtitle = smtitle;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreatname() {
        return creatname;
    }

    public void setCreatname(String creatname) {
        this.creatname = creatname;
    }

    public String getModifyname() {
        return modifyname;
    }

    public void setModifyname(String modifyname) {
        this.modifyname = modifyname;
    }

    public String getCreategroupname() {
        return creategroupname;
    }

    public void setCreategroupname(String creategroupname) {
        this.creategroupname = creategroupname;
    }

    public String getModifygroupname() {
        return modifygroupname;
    }

    public void setModifygroupname(String modifygroupname) {
        this.modifygroupname = modifygroupname;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getKeyward() {
        return keyward;
    }

    public void setKeyward(String keyward) {
        this.keyward = keyward;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}