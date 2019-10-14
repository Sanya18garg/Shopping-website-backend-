package com.caseStudy.eCart.Respository;

import com.caseStudy.eCart.modals.Orderhistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends JpaRepository<Orderhistory,Long> {
}
