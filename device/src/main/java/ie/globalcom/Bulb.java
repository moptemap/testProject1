package ie.globalcom;

import by.pavel.bean.Device;

public class Bulb implements Device {

    private boolean online;

    public boolean toggle() {
        if(online) {
            online = false;
            return online;
        }

        online = true;
        return online;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
