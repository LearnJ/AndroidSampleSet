package com.example.jiamao.listviewtest;

/**
 * Created by jiamao on 2018/1/2.
 */

public class MsgInfo {

    private String message;
    private int icon_id;
    private int view_type;

    public int getView_type() {
        return view_type;
    }

    public void setView_type(int view_type) {
        this.view_type = view_type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(int icon_id) {
        this.icon_id = icon_id;
    }
}
