package com.google.code.ant.growlnotify;

import java.io.IOException;
import java.util.ArrayList;

class Growl {

    public void sendNotification(GrowlNotification notification) throws GrowlException {
        ArrayList<String> args = new ArrayList<String>();
        args.add("growlnotify");
        args.add("-m");
        args.add(notification.msg);
        args.add("-n");
        args.add(notification.appName);
        args.add("-t");
        args.add(notification.title);
        if (notification.sticky)
            args.add("-s");
        try {
            Process exec = Runtime.getRuntime().exec(args.toArray(new String[] {}));
        } catch (IOException e) {
            throw new GrowlException(e);
        }
    }
}
