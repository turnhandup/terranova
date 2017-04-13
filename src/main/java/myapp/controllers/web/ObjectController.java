package myapp.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by PANNA on 12.04.2017.
 */
@Controller
@RequestMapping(value="web/admin")
public class ObjectController {
    @RequestMapping(value = "{id}/editobject", method = RequestMethod.GET)
    public String editAuthor(@PathVariable("id") int id,
                             Model model){
        model.addAttribute("id", id);
        return "/admin/objectEdit";
    }
    @RequestMapping(value = "{id}/editobjectarchitector", method = RequestMethod.GET)
    public String editObjectByArchitector(@PathVariable("id") int id,
                             Model model){
        model.addAttribute("id", id);
        return "/architector/objectEditArchitector";
    }
}
