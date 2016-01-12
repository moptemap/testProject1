package by.pavel.controller;

import by.pavel.bean.KeywordBean;
import by.pavel.bean.MessageBean;
import by.pavel.entity.ClassName;
import by.pavel.service.ClassNameService;
import by.pavel.service.DeviceService;
import by.pavel.service.MessageService;
import by.pavel.service.impl.ClassNameServiceImpl;
import by.pavel.service.impl.DeviceServiceImpl;
import by.pavel.service.impl.MessageServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/device-toggle")
public class DeviceController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClassNameService classNameService = new ClassNameServiceImpl();
        DeviceService deviceService = new DeviceServiceImpl();
        MessageService messageService = new MessageServiceImpl();

        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";

        if(br != null){
            json = br.readLine();
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        KeywordBean keywordBean = gson.fromJson(json, KeywordBean.class);
        String keyword = keywordBean.getKeyword();
        ClassName className = classNameService.getClassNameByKeyword(keyword);
        MessageBean message = null;

        if(className != null){
            try {
                boolean deviceOnline = deviceService.toggleDevice(className.getName());
                message = messageService.getDeviceToggleMessage(className.getName(), deviceOnline);
            } catch (Exception e) {
                message = messageService.getDeviceNotFoundMessage();
            }
        } else {
            message = messageService.getDeviceNotFoundMessage();
        }

        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(message));

    }

}
