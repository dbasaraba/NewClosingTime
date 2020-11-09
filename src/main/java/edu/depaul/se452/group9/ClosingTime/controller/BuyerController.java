package edu.depaul.se452.group9.ClosingTime.controller;

import edu.depaul.se452.group9.ClosingTime.dao.BuyerDAO;
import edu.depaul.se452.group9.ClosingTime.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuyerController {

    @Autowired
    private BuyerDAO buyerDAO;

    @RequestMapping("/buyers/new") // render signup page for buyer
    public String newBuyer(Model model) {
        model.addAttribute("buyer", new Buyer());
        return "buyer/buyerForm";
    }

    @RequestMapping("/buyers") // show all buyers
    public String getBuyers(Model model) {
        model.addAttribute("buyers", buyerDAO.getBuyers());
        return "buyer/buyers";
    }

    @RequestMapping("/buyers/{id}") // show single buyer
    public String getBuyer(@PathVariable("id") String id, Model model) {
        model.addAttribute("buyer", buyerDAO.getBuyer(id));
        return "buyer/buyer";
    }

    @RequestMapping("/buyers/edit/{id}") // render edit page for buyer
    public String editBuyer(@PathVariable("id") String id, Model model) {
        model.addAttribute("buyer", buyerDAO.getBuyer(id));
        return "buyer/buyerForm";
    }

    @RequestMapping("/buyers/process") // create or edit new buyer
    public String processBuyer(@ModelAttribute Buyer buyer) {
        buyerDAO.processBuyer(buyer);
        return "redirect:/buyers";
    }

    @RequestMapping("/buyers/delete/{id}") // delete buyer
    public String deleteBuyer(@PathVariable("id") String id) {
        buyerDAO.deleteBuyer(id);
        return "redirect:/buyers";
    }

}
