package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer gw = new Customer();
        gw.setFirstName("George");
        gw.setLastName("Washington");
        gw.setAddress("1224 Apple Lane");
        gw.setPhone("316-899-5465");
        gw.setPostal_code("56485");

        Customer ja = new Customer();
        ja.setFirstName("John");
        ja.setLastName("Adams");
        ja.setAddress("870 Banana Place");
        ja.setPhone("845-654-8758");
        ja.setPostal_code("84464");

        Customer tj = new Customer();
        tj.setFirstName("Thomas");
        tj.setLastName("Jefferson");
        tj.setAddress("124 Cherry Street");
        tj.setPhone("512-822-2232");
        tj.setPostal_code("22241");

        Customer jm = new Customer();
        jm.setFirstName("James");
        jm.setLastName("Madison");
        jm.setAddress("987 Peach Court");
        jm.setPhone("954-322-1252");
        jm.setPostal_code("54362");

        Customer jmon = new Customer();
        jmon.setFirstName("James");
        jmon.setLastName("Monroe");
        jmon.setAddress("4454 Watermelon Way");
        jmon.setPhone("111-874-6585");
        jmon.setPostal_code("12252");

        List<Customer> customerList = (List<Customer>) customerRepository.findAll();

        if (
            customerList.get(0).getFirstName().equals("John") &&
            customerList.get(0).getLastName().equals("Doe") &&
            customerRepository.count() <= 1
           )
            {
            this.customerRepository.save(gw);
            this.customerRepository.save(ja);
            this.customerRepository.save(tj);
            this.customerRepository.save(jm);
            this.customerRepository.save(jmon);
            System.out.println("Boostrap Initialized default customers:");
            customerList = (List<Customer>) customerRepository.findAll();
            for (int i = 0; i < 6; i++) {
                System.out.println("- " + customerList.get(i).getFirstName() + " " + customerList.get(i).getLastName());
            }
        }
    }
}
