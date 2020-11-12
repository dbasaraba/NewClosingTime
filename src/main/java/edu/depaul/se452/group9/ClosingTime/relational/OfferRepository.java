package edu.depaul.se452.group9.ClosingTime.relational;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Buyer, Long>
{

}