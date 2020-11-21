package edu.depaul.se452.group9.ClosingTime.dao;

import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IBuyerRespository;
import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IMessengerRepository;
import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IOfferRepository;
import edu.depaul.se452.group9.ClosingTime.entity.Buyer;
import edu.depaul.se452.group9.ClosingTime.entity.Messenger;
import edu.depaul.se452.group9.ClosingTime.entity.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuyerDAO {

    @Autowired
    private IBuyerRespository repository;

    @Autowired
    private IMessengerRepository messengerRepository;

    @Autowired
    private IOfferRepository offerRepository;

    public List<Buyer> getBuyers() { return repository.findAll(); }

    public List<Messenger> getSentMessages(Buyer buyer) {
        return messengerRepository.findAll().stream().
                filter(m -> m.getBuyerId().equals(buyer.getId())).collect(Collectors.toList());
    }

    public List<Messenger> getRecievedMessages(Buyer buyer) {
        return messengerRepository.findAll().stream().
                filter(m -> m.getToBuyer().equals(buyer.getId())).collect(Collectors.toList());
    }

    public List<Offer> getOffers(Buyer buyer) {
        return offerRepository.findAll().stream().
                filter(o -> o.getBuyerId().equals(buyer.getId())).collect(Collectors.toList());
    }

    public Buyer getBuyer(String id) { return repository.findById(id).orElse(null); }

    public void processBuyer(Buyer buyer) { repository.save(buyer); }

    public void deleteBuyer(String id) { repository.deleteById(id); }

}
