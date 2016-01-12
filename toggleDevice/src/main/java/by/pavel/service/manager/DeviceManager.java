package by.pavel.service.manager;

import by.pavel.bean.Device;
import by.pavel.service.manager.exception.DeviceManagerException;

import java.util.HashMap;
import java.util.Map;

public class DeviceManager {

    private Map<Class, Device> devices = new HashMap<>();
    private static DeviceManager instance = new DeviceManager();

    private DeviceManager() {
    }

    public boolean toggleDevice(Class clazz) throws IllegalAccessException, InstantiationException {
        Device device = devices.get(clazz);

        if(device != null) {
            return device.toggle();
        }

        return addDevice(clazz).toggle();
    }

    public Device addDevice(Class clazz) throws IllegalAccessException, InstantiationException {
        if(devices.get(clazz) == null) {
            if(implementedDeviceInterface(clazz)) {
                Device device = (Device) clazz.newInstance();
                devices.put(clazz, device);
                return device;
            }
        }

        throw new DeviceManagerException();
    }

    private boolean implementedDeviceInterface(Class clazz) {
        for(Class interfaceClass : clazz.getInterfaces()) {
            if(interfaceClass.equals(Device.class)) {
                return true;
            }
        }

        return false;
    }

    public static DeviceManager getInstance() {
        return instance;
    }
}
