package myapp.controllers.rest;

import myapp.persistence.entities.OrdererEntity;
import myapp.pojo.Response;
import myapp.services.convertors.Fields;
import myapp.services.utils.OrdererService;
import myapp.services.utils.ResponseFactory;
import myapp.views.OrdererView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ejb.NoSuchEntityException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 09.04.2017.
 */
@Controller
@RequestMapping(value = "/api/orderers")
public class OrdererApiController {
    @Autowired
    private OrdererService ordererService;
    @Autowired
    private ResponseFactory responseFactory;
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public
    @ResponseBody
    Response<Map<String, Object>>
    getOrderer(
            @PathVariable("id") int userId,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Orderer.DEFAULT) Set<String> fields
    ) {
        return responseFactory.get(ordererService.getOrdererById(userId, fields));
    }
    @RequestMapping(
            value="/",
            method=RequestMethod.GET
    )
    public
    @ResponseBody
    Response<List<Map<String,Object>>>
    getOrderers(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Orderer.DEFAULT) Set<String> fields
    ){
        return responseFactory.get(ordererService.getAllOrderersMap(offset, limit, fields));
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<OrdererEntity>
    update(@RequestBody OrdererView ordererView) throws NoSuchEntityException {
        System.out.println(ordererView.toString());
        Response<OrdererEntity> arc=responseFactory.get(ordererService.updateOrderer(ordererView));
        System.out.print("VIEW FROM ENTITY"+ordererView.toString());
        return responseFactory.get(ordererService.updateOrderer(ordererView));
    }
    @RequestMapping(
                value="/create",
                method=RequestMethod.PUT
        )
    public
    @ResponseBody Response<Integer>
    create(@RequestBody OrdererView ordererView) throws NoSuchEntityException{
        return responseFactory.get(ordererService.create(ordererView));
    }

}
