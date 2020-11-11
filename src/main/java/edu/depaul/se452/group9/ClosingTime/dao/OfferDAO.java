package edu.depaul.se452.group9.ClosingTime.dao;

import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IOfferRepository;
import edu.depaul.se452.group9.ClosingTime.entity.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfferDAO {

    @Autowired
    private IOfferRepository repository;

    public List<Offer> getOffers() { return repository.findAll(); }

    public Offer getOffer(String id) { return repository.findById(id).orElse(null); }

    public void processOffer(Offer offer) { repository.save(offer); }

    public void deleteOffer(String id) { repository.deleteById(id); }

}
