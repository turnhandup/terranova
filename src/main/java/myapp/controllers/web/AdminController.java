package myapp.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by PANNA on 08.04.2017.
 */
@Controller
@RequestMapping(value = "/web/admin/")
public class AdminController {
    @RequestMapping(value = "/zvit", method = RequestMethod.GET)
    public String editAuthor(){
        return "/admin/zvit";
    }
}
