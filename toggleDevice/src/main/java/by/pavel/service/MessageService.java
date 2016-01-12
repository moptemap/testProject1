package by.pavel.service;

import by.pavel.bean.MessageBean;

public interface MessageService {

    MessageBean getDeviceToggleMessage(String className, boolean deviceOnline);
    MessageBean getDeviceNotFoundMessage();
}
