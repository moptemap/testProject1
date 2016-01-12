package by.pavel.service.impl;

import by.pavel.service.DeviceService;
import by.pavel.service.manager.DeviceManager;

public class DeviceServiceImpl implements DeviceService {

    @Override
    public boolean toggleDevice(String className) {
        try {
            DeviceManager deviceManager = DeviceManager.getInstance();
            Class clazz = Class.forName(className);

            return deviceManager.toggleDevice(clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
