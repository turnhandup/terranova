package myapp.controllers.rest;

import myapp.persistence.entities.ObjectEntity;
import myapp.pojo.Response;
import myapp.services.convertors.Fields;
import myapp.services.utils.ObjectService;
import myapp.services.utils.ResponseFactory;
import myapp.views.ObjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 12.04.2017.
 */
@Controller
@RequestMapping(value="/api/objects")
public class ObjectApiController {
    @Autowired
    ObjectService objectService;

    @Autowired
    ResponseFactory responseFactory;
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public
    @ResponseBody
    Response<Map<String, Object>>
    getObject(
            @PathVariable("id") int objectId,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Orderer.DEFAULT) Set<String> fields
    ) {
        return responseFactory.get(objectService.getObjectByIdMap(objectId,fields));
    }
    @RequestMapping(value="/", method = RequestMethod.GET)
    public
    @ResponseBody
    Response<List<Map<String,Object>>>
    getObjects(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Object.DEFAULT) Set<String> fields
    ){
        return responseFactory.get(objectService.getAllObjectsMap(offset,limit,fields));
    }
    @RequestMapping(value="/{id}/architector", method=RequestMethod.GET)
    public
    @ResponseBody
    Response<List<Map<String,Object>>>
    getObjectsByArchitector(
            @PathVariable("id") int id_architector,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Object.DEFAULT) Set<String> fields
    ) {
        System.out.println(fields);
        return responseFactory.get(objectService.getAllObjectsByArchitectorMap(offset,limit, id_architector,fields));
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public
    @ResponseBody
    Response<ObjectEntity>
    update(@RequestBody ObjectView objectView) throws NoSuchEntityException{
        return responseFactory.get(objectService.update(objectView));
    }

    @RequestMapping(value="/create",method=RequestMethod.PUT)
    public
    @ResponseBody Response<Integer>
    create(@RequestBody ObjectView objectView) throws NoSuchEntityException{
        return responseFactory.get(objectService.create(objectView));
    }
}
