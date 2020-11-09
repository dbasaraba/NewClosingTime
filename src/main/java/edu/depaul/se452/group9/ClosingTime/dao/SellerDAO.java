package edu.depaul.se452.group9.ClosingTime.dao;

import edu.depaul.se452.group9.ClosingTime.dao.interfaces.ISellerRepository;
import edu.depaul.se452.group9.ClosingTime.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellerDAO {

    @Autowired
    private ISellerRepository repository;

    public List<Seller> getSellers() { return repository.findAll(); }

    public Seller getSeller(String id) { return repository.findById(id).orElse(null); }

    public void processSeller(Seller seller) { repository.save(seller); }

    public void deleteSeller(String id) { repository.deleteById(id); }

}
