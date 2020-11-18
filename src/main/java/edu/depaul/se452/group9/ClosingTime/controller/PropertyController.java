package edu.depaul.se452.group9.ClosingTime.controller;

import edu.depaul.se452.group9.ClosingTime.dao.PropertyDAO;
import edu.depaul.se452.group9.ClosingTime.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertyController {

    @Autowired
    private PropertyDAO propertyDAO;

    @RequestMapping("/properties/new") // render signup page for property
    public String newProperty(Model model) {
        model.addAttribute("property", new Property());
        return "property/propertyForm";
    }

    @RequestMapping("/properties") // show all properties
    public String getProperties(Model model) {
        model.addAttribute("properties", propertyDAO.getProperties());
        return "property/properties";
    }

    @RequestMapping("/properties/{id}") // show single property
    public String getProperty(@PathVariable("id") String id, Model model) {
        Property property = propertyDAO.getProperty(id);
        property.setOffers(propertyDAO.getOffers(property));
        model.addAttribute("property", property);
        return "property/property";
    }

    @RequestMapping("/properties/edit/{id}") // render edit page for property
    public String editProperty(@PathVariable("id") String id, Model model) {
        model.addAttribute("property", propertyDAO.getProperty(id));
        propertyDAO.deleteProperty(id);
        return "property/propertyForm";
    }

    @PostMapping("/properties/process") // create or edit new property
    public String processProperty(@ModelAttribute Property property) {
        propertyDAO.processProperty(property);
        return "redirect:/properties";
    }

    @RequestMapping("/properties/delete/{id}") // delete property
    public String deleteProperties(@PathVariable("id") String id) {
        propertyDAO.deleteProperty(id);
        return "redirect:/properties";
    }


    @RequestMapping("/buy")
    public String displayProperties( Model model){
        model.addAttribute("properties",propertyDAO.getProperties());
        return "buy";
    }


}
