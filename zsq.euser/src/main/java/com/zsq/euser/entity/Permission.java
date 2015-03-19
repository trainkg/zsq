package com.zsq.euser.entity;

/**
 * 
 * @author peculiar.1@163.com
 * @version $ID: Permission.java, V1.0.0 2015年3月19日 下午10:16:41 $
 */
public class Permission {
    private String id;

    private String name;

    private String code;

    private String dictId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }
}