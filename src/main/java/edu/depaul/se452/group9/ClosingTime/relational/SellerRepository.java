package edu.depaul.se452.group9.ClosingTime.relational;

import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Buyer, Long> {
}
