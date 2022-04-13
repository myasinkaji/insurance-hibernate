package ir.dotin.insurance.hibernate.service;

import ir.dotin.insurance.hibernate.dao.StockDao;
import ir.dotin.insurance.hibernate.dao.StockDetailsDao;
import ir.dotin.insurance.hibernate.model.Stock;
import ir.dotin.insurance.hibernate.model.StockDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class StockManager {
    private final StockDao stockDao;
    private final StockDetailsDao stockDetailsDao;
    private final Random random = new Random();

    public void save() {
//        stockDao.findById(38L);
        final var stock = new Stock();
        long id = random.nextLong(1, 100);
        stock.setId(id);
        stock.setName("stock#" + id);

        final var details = new StockDetails();
        details.setId(id + 100);
        details.setStock(stock);
        details.setDetails("This is a details about the stock#" + id);

        stockDao.save(stock);
        stockDetailsDao.save(details);
    }
}
