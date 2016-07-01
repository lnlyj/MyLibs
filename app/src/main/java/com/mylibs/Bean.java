package com.mylibs;

/**
 * Created by wanglei on 16/5/30.
 */
public class Bean {

    private String title;
    private String desc;

    public Bean() {
    }

    public Bean(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
