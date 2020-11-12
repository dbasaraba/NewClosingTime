package edu.depaul.se452.group9.ClosingTime.dao;

import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IMessengerRepository;
import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IPropertyRepository;
import edu.depaul.se452.group9.ClosingTime.dao.interfaces.ISellerRepository;
import edu.depaul.se452.group9.ClosingTime.entity.Messenger;
import edu.depaul.se452.group9.ClosingTime.entity.Property;
import edu.depaul.se452.group9.ClosingTime.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SellerDAO {

    @Autowired
    private ISellerRepository repository;

    @Autowired
    private IPropertyRepository propertyRepository;

    @Autowired
    private IMessengerRepository messengerRepository;

    public List<Seller> getSellers() { return repository.findAll(); }

    public List<Property> getProperties(Seller seller) {
        return propertyRepository.findAll().stream().
                filter(property -> !property.getSellerId().equals(seller.getId())).collect(Collectors.toList());
    }

    public List<Messenger> getMessages(Seller seller) {
        return messengerRepository.findAll().stream().
                filter(property -> !property.getSellerId().equals(seller.getId())).collect(Collectors.toList());
    }

    public Seller getSeller(String id) { return repository.findById(id).orElse(null); }

    public void processSeller(Seller seller) { repository.save(seller); }

    public void deleteSeller(String id) { repository.deleteById(id); }

}
