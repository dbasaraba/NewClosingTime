package edu.depaul.se452.group9.ClosingTime.controller;

import edu.depaul.se452.group9.ClosingTime.dao.MessengerDAO;
import edu.depaul.se452.group9.ClosingTime.entity.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MessengerController {

    @Autowired
    private MessengerDAO messengerDAO;

    @RequestMapping("/messengers/new") // render signup page for messenger
    public String newMessenger(Model model) {
        model.addAttribute("messenger", new Messenger());
        return "messenger/messengerForm";
    }

    @RequestMapping("/messengers") // show all messengers
    public String getMessengers(Model model) {
        model.addAttribute("messengers", messengerDAO.getMessengers());
        return "messenger/messengers";
    }

    @RequestMapping("/messengers/{id}") // show single messenger
    public String getMessenger(@PathVariable("id") String id, Model model) {
        model.addAttribute("messenger", messengerDAO.getMessenger(id));
        return "messenger/messenger";
    }

    @RequestMapping("/messengers/edit/{id}") // render edit page for messenger
    public String editMessenger(@PathVariable("id") String id, Model model) {
        model.addAttribute("messenger", messengerDAO.getMessenger(id));
        messengerDAO.deleteMessenger(id);
        return "messenger/messengerForm";
    }

    @PostMapping("/messengers/process") // create or edit new messenger
    public String processMessenger(@ModelAttribute Messenger messenger) {
        messengerDAO.processMessenger(messenger);
        return "redirect:/messengers";
    }

    @RequestMapping("/messengers/delete/{id}") // delete messenger
    public String deleteMessenger(@PathVariable("id") String id) {
        messengerDAO.deleteMessenger(id);
        return "redirect:/messengers";
    }

}
