package com.google.code.ant.growlnotify;


class GrowlNotification {
    public static final int HIGH = 2;
    public static final int NORMAL = 0;
    public final String appName;
    public final String title;
    public final String msg;
    public final boolean sticky;
    

    public GrowlNotification(String appName, String title, String msg, int priority, boolean sticky) {
        this.appName = appName;
        this.title = title;
        this.msg = msg;
        this.sticky = sticky;
    }

}
