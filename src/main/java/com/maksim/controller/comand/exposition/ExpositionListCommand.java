package com.maksim.controller.comand.exposition;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.domain.Exposition;
import com.maksim.model.dao.ExpositionDao;
import com.maksim.model.impl.DaoFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class ExpositionListCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        ExpositionDao expositionDao = DaoFactoryImpl.getInstance().getExpositionDao();
        List<Exposition> list =  expositionDao.findAll();

        request.setAttribute("listOfExpositions", list);

        page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ALL_EXPOSITIONS_PAGE_PATH);

        return page;
    }
}
