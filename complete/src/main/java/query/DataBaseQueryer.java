package query;

import com.mysema.query.jpa.impl.JPAQuery;
import hello.Customer;
import hello.QCustomer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class DataBaseQueryer {

    @Autowired
    EntityManager entityManager;

    public List<Customer> seleteAllCustomer(){
        QCustomer qCustomer = QCustomer.customer;
        List<Customer> customerList = new JPAQuery(entityManager)
                .from(qCustomer)
                .where(qCustomer.id.isNotNull())
                .list(qCustomer);

        return customerList;
    }
}
