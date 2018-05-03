package com.maksim.controller.comand;

import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.domain.Exposition;
import com.maksim.domain.User;
import com.maksim.model.dao.ExpositionDao;
import com.maksim.model.impl.ExpositionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Максим on 03/May/18.
 */
public class BasketCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        BigDecimal totalPrice = new BigDecimal("0.0");;
        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute(PARAM_USER);




        ExpositionDao expositionDao = new ExpositionDaoImpl();
        int expositionAllId = expositionDao.findAllId().size();
        se.setAttribute(PARAM_EXPOSITION_ALL_ID, expositionAllId);

//        java.util.Enumeration cats = request.getAttributeNames();
//        List<Object> list = java.util.Collections.list(cats);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        for (int i = 1; i <= expositionAllId; i++) {
            String expositionId = request.getParameter(PARAM_EXPOSITION + i);
            if (expositionId != null) {
                Exposition exposition = expositionDao.findById(Integer.parseInt(expositionId));

                se.setAttribute(PARAM_IS_EXPOSITION, "?//D");
                se.setAttribute(PARAM_EXPOSITION+ i, exposition);

                totalPrice=totalPrice.add(exposition.getPrice());

            }
        }
        se.setAttribute(PARAM_TOTAL_PRICE, totalPrice);

//        String publicationId = request.getParameter("publicationId");
//
//        PublicationDAO publicationDAO = new PublicationDaoImpl();
//        Publication publication = publicationDAO.findById(Integer.parseInt(publicationId));
//        se.setAttribute("publication", publication);

//            System.out.println("______________________");
//            System.out.println(publication);
//            System.out.println("______________________");


//       Integer publicationId = (Integer) se.getAttribute("publication.publicationId");
//        System.out.println(publicationId);
//        String publicationId = request.getParameter("publicationId");

        if (user != null) {

            page = UserSession.loadUserDataToSession(request, user);


//            se.setAttribute("user", user);
//            se.setAttribute("name", user.getFullName());
//            se.setAttribute("publication", publication);
//            page = UserSession.loadUserDataToSession(request, user);
//            page =ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);


//            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);

        } else {
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
        }
        return page;
    }
}
