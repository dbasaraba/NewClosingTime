package edu.depaul.se452.group9.ClosingTime.controller;

import edu.depaul.se452.group9.ClosingTime.dao.OfferDAO;
import edu.depaul.se452.group9.ClosingTime.entity.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OfferController {

    @Autowired
    private OfferDAO offerDAO;

    @RequestMapping("/offers/new") // render signup page for offer
    public String newOffer(Model model) {
        model.addAttribute("offer", new Offer());
        return "offer/offerForm";
    }

    @RequestMapping("/offers") // show all offers
    public String getOffers(Model model) {
        model.addAttribute("offers", offerDAO.getOffers());
        return "offer/offers";
    }

    @RequestMapping("/offers/{id}") // show single offer
    public String getOffer(@PathVariable("id") String id, Model model) {
        model.addAttribute("offer", offerDAO.getOffer(id));
        return "offer/offer";
    }

    @RequestMapping("/offers/edit/{id}") // render edit page for offer
    public String editOffer(@PathVariable("id") String id, Model model) {
        model.addAttribute("offer", offerDAO.getOffer(id));
        offerDAO.deleteOffer(id);
        return "offer/offerForm";
    }

    @PostMapping("/offers/process") // create or edit new offer
    public String processOffer(@ModelAttribute Offer offer) {
        offerDAO.processOffer(offer);
        return "redirect:/offers";
    }

    @RequestMapping("/offers/delete/{id}") // delete offer
    public String deleteOffer(@PathVariable("id") String id) {
        offerDAO.deleteOffer(id);
        return "redirect:/offers";
    }

}
