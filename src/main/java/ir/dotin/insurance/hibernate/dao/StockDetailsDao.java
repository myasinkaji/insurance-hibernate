package ir.dotin.insurance.hibernate.dao;

import ir.dotin.insurance.hibernate.model.StockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDetailsDao extends JpaRepository<StockDetails, Long> {
}
