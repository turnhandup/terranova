package myapp.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by PANNA on 09.04.2017.
 */
@Controller
@RequestMapping("/web/admin")
public class OrdererController {
    @RequestMapping(value = "{id}/editorderer", method = RequestMethod.GET)
    public String editAuthor(@PathVariable("id") int id,
                             Model model){
        model.addAttribute("id", id);
        return "/admin/ordererEdit";
    }

    @RequestMapping(value="/createorderer", method=RequestMethod.GET)
    public String createOrderer(){
        return "/admin/ordererCreate";
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String register(){ return "/register";}
}
