package com.maksim.controller.comand;

import com.maksim.controller.manager.UserSession;
import com.maksim.model.domain.Exposition;
import com.maksim.model.domain.User;
import com.maksim.model.dao.ExpositionDao;
import com.maksim.model.impl.DaoFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class BasketCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute(PARAM_USER);
        List<Exposition> list = new ArrayList<>();

        ExpositionDao expositionDao = DaoFactoryImpl.getInstance().getExpositionDao();
        int expositionAllId = expositionDao.findAllId();
        System.out.println(expositionAllId);

        if(se.getAttribute(LIST_OF_USER_EXPOSITIONS)==null) {
            for (int i = 1; i <= expositionAllId; i++) {
                String expositionId = request.getParameter(PARAM_EXPOSITION + i);

                if (expositionId != null) {
                    Exposition exposition = expositionDao.findById(Integer.parseInt(expositionId));
                    list.add(exposition);

//                se.setAttribute(PARAM_IS_EXPOSITION, "?//D");
                    se.setAttribute(PARAM_EXPOSITION + i, exposition);
                }
            }
            LocalDate today = LocalDate.now();
            se.setAttribute("today", today);

            se.setAttribute(LIST_OF_USER_EXPOSITIONS, list);
        }
        return  UserSession.loadUserDataToSession(request);
//        if (user != null) {
//
//            page = UserSession.loadUserDataToSession(request);
//
//        } else {
//            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
//        }
//        return page;
    }
}
