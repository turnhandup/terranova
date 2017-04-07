package myapp.controllers.web;

import myapp.pojo.Response;
import myapp.services.convertors.Fields;
import myapp.services.utils.ArchitectorService;
import myapp.services.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 06.04.2017.
 */
@Controller
@RequestMapping(value = "/api/architectors")
public class ArchitectorController {
    @Autowired
    private ArchitectorService architectorService;
    @Autowired
    private ResponseFactory responseFactory;
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public
    @ResponseBody
    Response<Map<String, Object>>
    getUser(
            @PathVariable("id") int userId,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Architector.DEFAULT) Set<String> fields
    ) {
        System.out.print(fields);
        return responseFactory.get(architectorService.getArchitectorByIdMap(userId, fields));
    }

    @RequestMapping(
            value="/",
            method=RequestMethod.GET
    )
    public
    @ResponseBody
    Response<List<Map<String,Object>>>
    getUsers(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Architector.DEFAULT) Set<String> fields
    ){
        return responseFactory.get(architectorService.getAllArchitectorsMap(offset, limit, fields));
    }


}
