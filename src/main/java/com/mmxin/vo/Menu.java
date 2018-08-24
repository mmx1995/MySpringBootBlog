package com.mmxin.vo;

import java.io.Serializable;

/**
 * @author : mmxin
 * @className : Menu
 * @date : 2018/8/24 11:40
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -5565673770998453040L;
    private String name;
    private String url;

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
