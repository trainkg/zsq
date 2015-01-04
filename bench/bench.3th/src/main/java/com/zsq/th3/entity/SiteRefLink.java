package com.zsq.th3.entity;

public class SiteRefLink {
    private String id;

    private String name;

    private String linkurl;

    private byte[] linkicon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public byte[] getLinkicon() {
        return linkicon;
    }

    public void setLinkicon(byte[] linkicon) {
        this.linkicon = linkicon;
    }
}