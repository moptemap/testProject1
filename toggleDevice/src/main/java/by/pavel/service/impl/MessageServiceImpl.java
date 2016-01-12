package by.pavel.service.impl;

import by.pavel.bean.MessageBean;
import by.pavel.service.MessageService;

public class MessageServiceImpl implements MessageService {

    @Override
    public MessageBean getDeviceToggleMessage(String className, boolean deviceOnline) {
        String[] partClassName = className.split("\\.");
        String deviceName = partClassName[partClassName.length -1];

        if(deviceOnline) {
            return new MessageBean(deviceName + ": i am turned on!");
        }

        return new MessageBean(deviceName + ": i am turned off!");
    }

    @Override
    public MessageBean getDeviceNotFoundMessage() {
        return new MessageBean("Device not found!");
    }
}
