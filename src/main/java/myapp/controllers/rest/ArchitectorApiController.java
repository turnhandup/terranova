package myapp.controllers.rest;

import myapp.persistence.entities.ArchitectorEntity;
import myapp.pojo.Response;
import myapp.services.convertors.Fields;
import myapp.services.utils.ArchitectorService;
import myapp.services.utils.ResponseFactory;
import myapp.views.ArchitectorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 06.04.2017.
 */
@Controller
@RequestMapping(value = "/api/architectors")
public class ArchitectorApiController {
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
//        System.out.print(fields);
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

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<ArchitectorEntity>
    update(@RequestBody ArchitectorView architectorView) throws NoSuchEntityException {
        Response<ArchitectorEntity> arc=responseFactory.get(architectorService.updateArchitector(architectorView));
//        System.out.print(arc.getResult().toString());
        return responseFactory.get(architectorService.updateArchitector(architectorView));
    }
    @RequestMapping(
            value="/create",
            method=RequestMethod.PUT
    )
    public
    @ResponseBody Response<Integer>
    create(@RequestBody ArchitectorView architectorView) throws  NoSuchEntityException{
                return responseFactory.get(architectorService.create(architectorView));
    }
}
