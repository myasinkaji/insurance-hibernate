package ir.dotin.insurance.hibernate;

import ir.dotin.insurance.hibernate.dao.StockDao;
import ir.dotin.insurance.hibernate.dao.StockDetailsDao;
import ir.dotin.insurance.hibernate.model.Stock;
import ir.dotin.insurance.hibernate.model.StockDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InsuranceHibernateApplicationTests /*extends BaseCoreFunctionalTestCase*/ {

	private final Random random = new Random();
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private StockDao stockDao;
	@Autowired
	private StockDetailsDao stockDetailsDao;

	@Test
	void contextLoads() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(stockDao).isNotNull();
	}

	@Test
	void testSaveStock() {
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
