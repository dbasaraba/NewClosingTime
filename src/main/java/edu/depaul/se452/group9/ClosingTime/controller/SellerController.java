package edu.depaul.se452.group9.ClosingTime.controller;

import edu.depaul.se452.group9.ClosingTime.dao.SellerDAO;
import edu.depaul.se452.group9.ClosingTime.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SellerController {

    @Autowired
    private SellerDAO sellerDAO;

    @RequestMapping("/sellers/new") // render signup page for seller
    public String newSeller(Model model) {
        model.addAttribute("seller", new Seller());
        return "seller/sellerForm";
    }

    @RequestMapping("/sellers") // show all sellers
    public String getSellers(Model model) {
        model.addAttribute("sellers", sellerDAO.getSellers());
        return "seller/sellers";
    }

    @RequestMapping("/sellers/{id}") // show single seller
    public String getSeller(@PathVariable("id") String id, Model model) {
        Seller seller = sellerDAO.getSeller(id);
        seller.setProperties(sellerDAO.getProperties(seller));
        seller.setMessages(sellerDAO.getMessages(seller));
        model.addAttribute("seller", seller);
        return "seller/seller";
    }

    @RequestMapping("/sellers/edit/{id}") // render edit page for seller
    public String editseller(@PathVariable("id") String id, Model model) {
        model.addAttribute("seller", sellerDAO.getSeller(id));
        sellerDAO.deleteSeller(id);
        return "seller/sellerForm";
    }

    @PostMapping("/sellers/process") // create or edit new seller
    public String processSeller(@ModelAttribute Seller seller) {
        sellerDAO.processSeller(seller);
        return "redirect:/sellers";
    }

    @RequestMapping("/sellers/delete/{id}") // delete seller
    public String deleteSeller(@PathVariable("id") String id) {
        sellerDAO.deleteSeller(id);
        return "redirect:/sellers";
    }

}
