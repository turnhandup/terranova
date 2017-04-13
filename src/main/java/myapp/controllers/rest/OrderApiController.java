package myapp.controllers.rest;

import myapp.persistence.entities.OrderEntity;
import myapp.persistence.entities.OrdererEntity;
import myapp.pojo.Response;
import myapp.services.convertors.Fields;
import myapp.services.utils.OrderService;
import myapp.services.utils.OrdererService;
import myapp.services.utils.ResponseFactory;
import myapp.views.OrderView;
import myapp.views.OrdererView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 13.04.2017.
 */
@Controller
@RequestMapping(value = "/api/orders")
public class OrderApiController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ResponseFactory responseFactory;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public
    @ResponseBody
    Response<Map<String, Object>>
    getOrder(
            @PathVariable("id") int userId,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Order.DEFAULT) Set<String> fields
    ) {
        return responseFactory.get(orderService.getOrderById(userId, fields));
    }

    @RequestMapping(
            value="/{id}/orderer",
            method=RequestMethod.GET
    )
    public
    @ResponseBody
    Response<List<Map<String,Object>>>
    getOrders(
            @PathVariable("id") int id_orderer,
            @RequestParam(value = "fields", required = false, defaultValue = Fields.Order.DEFAULT) Set<String> fields
    ){
        return responseFactory.get(orderService.getAllOrdersMap(id_orderer,fields));
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public
    @ResponseBody Response<OrderEntity>
    update(@RequestBody OrderView orderView) throws NoSuchEntityException {
        return responseFactory.get(orderService.updateOrder(orderView));
    }

    @RequestMapping(
            value="/create",
            method=RequestMethod.PUT
    )
    public
    @ResponseBody Response<Integer>
    create(@RequestBody OrderView orderView) throws NoSuchEntityException{
        return responseFactory.get(orderService.addOrder(orderView));
    }

}
