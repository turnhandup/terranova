package myapp.controllers.rest;

import myapp.persistence.dao.CustomQueriesDao;
import myapp.persistence.entities.CustomQueriesEntities;
import myapp.pojo.Response;
import myapp.services.convertors.Fields;
import myapp.services.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 13.04.2017.
 */
@Controller
@RequestMapping(value = "/api/cq")
public class CustomQueriesControler {
    @Autowired
    CustomQueriesDao cqDao;
    @Autowired
    private ResponseFactory responseFactory;

    @RequestMapping(
            value = "/workdone",
            method = RequestMethod.GET
    )
    public
    @ResponseBody
    Response<List<CustomQueriesEntities.WorkDone>>
    getResults() {
        return responseFactory.get(cqDao.workDone());
    }
}
