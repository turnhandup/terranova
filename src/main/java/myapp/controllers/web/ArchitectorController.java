package myapp.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.lang.ref.ReferenceQueue;

/**
 * Created by PANNA on 08.04.2017.
 */

@Controller
@RequestMapping("/web/admin")
public class ArchitectorController {
        @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
        public String editAuthor(@PathVariable("id") int id,
                                 Model model){
            model.addAttribute("id", id);
            return "/admin/architectorEdit";
    }
    @RequestMapping(value="/createarchitector",method=RequestMethod.GET)
    public String createArchitector(){
            return "/admin/createArchitector";
    }
}
