package edu.depaul.se452.group9.ClosingTime.dao;

import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IOfferRepository;
import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IPropertyRepository;
import edu.depaul.se452.group9.ClosingTime.entity.Offer;
import edu.depaul.se452.group9.ClosingTime.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PropertyDAO {

    @Autowired
    private IPropertyRepository repository;

    @Autowired
    private IOfferRepository offerRepository;

    public List<Property> getProperties() { return repository.findAll(); }

    public List<Offer> getOffers(Property property) {
        return offerRepository.findAll().stream().
                filter(o -> o.getPropertyId().equals(property.getId())).collect(Collectors.toList());
    }

    public Property getProperty(String id) { return repository.findById(id).orElse(null); }

    public void processProperty(Property property) { repository.save(property); }

    public void deleteProperty(String id) { repository.deleteById(id); }

}
