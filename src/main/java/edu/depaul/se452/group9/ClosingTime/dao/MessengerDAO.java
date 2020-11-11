package edu.depaul.se452.group9.ClosingTime.dao;

import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IMessengerRepository;
import edu.depaul.se452.group9.ClosingTime.entity.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessengerDAO {

    @Autowired
    private IMessengerRepository repository;

    public List<Messenger> getMessengers() { return repository.findAll(); }

    public Messenger getMessenger(String id) { return repository.findById(id).orElse(null); }

    public void processMessenger(Messenger messenger) { repository.save(messenger); }

    public void deleteMessenger(String id) { repository.deleteById(id); }

}
