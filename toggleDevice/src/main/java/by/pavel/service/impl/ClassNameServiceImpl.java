package by.pavel.service.impl;

import by.pavel.dao.ClassNameDAO;
import by.pavel.dao.impl.ClassNameDAOImpl;
import by.pavel.entity.ClassName;
import by.pavel.service.ClassNameService;

public class ClassNameServiceImpl implements ClassNameService {

    @Override
    public ClassName getClassNameByKeyword(String keyword) {
        ClassNameDAO classNameDAO = new ClassNameDAOImpl();
        return classNameDAO.loadClassNameByKeyword(keyword);
    }
}
