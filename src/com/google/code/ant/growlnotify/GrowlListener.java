package com.google.code.ant.growlnotify;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;

public class GrowlListener implements BuildListener {

    private static final String APP_NAME = "Ant";
    private Growl growl = new Growl();

    public void buildStarted(BuildEvent event) {
        sendMessage("Build started", GrowlNotification.NORMAL, false);
    }

    public void buildFinished(BuildEvent event) {
        Throwable exception = event.getException();
        String projectName = event.getProject().getName();
        if (exception != null) {
            sendMessage("Build failed: " + exception.toString(), GrowlNotification.HIGH, true);
            return;
        }
        sendMessage("Build finished for " + projectName, GrowlNotification.NORMAL, true);
    }

    public void messageLogged(BuildEvent event) {
    }

    public void targetFinished(BuildEvent event) {
        sendMessage("Finished target: " + event.getTarget(), GrowlNotification.NORMAL, false);
    }

    public void targetStarted(BuildEvent event) {
        sendMessage("Started target: " + event.getTarget(), GrowlNotification.NORMAL, false);
    }

    public void taskFinished(BuildEvent event) {
    }

    public void taskStarted(BuildEvent event) {
    }

    protected void sendMessage(String msg, int priority, boolean sticky) {
        try {
            growl.sendNotification(new GrowlNotification(APP_NAME, APP_NAME, msg, priority, sticky));
        } catch (GrowlException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GrowlListener gl = new GrowlListener();
        gl.sendMessage("Testing Testing", GrowlNotification.NORMAL, true);
    }
}