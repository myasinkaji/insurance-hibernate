package ir.dotin.insurance.hibernate.dao;

import ir.dotin.insurance.hibernate.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<Stock, Long> {
}
