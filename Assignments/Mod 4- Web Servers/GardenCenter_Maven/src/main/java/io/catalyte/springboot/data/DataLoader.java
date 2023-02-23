package io.catalyte.springboot.data;

import io.catalyte.springboot.entities.*;
import io.catalyte.springboot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private Users users;
    private Address address;
    private Customers customers;
    private Products products;
    private Orders orders;
    private Items items;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ItemsRepository itemsRepository;


    private Users user1;
    private Users user2;
    private Users user3;
    private Users user4;
    private Users user5;


    private Customers customer1;
    private Customers customer2;
    private Customers customer3;
    private Customers customer4;
    private Customers customer5;
    private Customers customer6;

    private Products product1;
    private Products product2;
    private Products product3;

    private Orders order1;
    private Orders order2;
    private Orders order3;
    private Orders order4;
    private Orders order5;
    private Orders order6;
    private Orders order7;
    private Orders order8;
    private Orders order9;


    private Items item1;
    private Items item2;
    private Items item3;
    private Items item4;

    @Override
    public void run(String... args) throws Exception{
        loadUsers();
        loadCustomers();
        loadProducts();
        loadOrders();

        loadItems();
//        loadAddress();

    }

    private void loadUsers(){
        user1 = usersRepository.save(new Users("Harry Potter","CEO", List.of("Admin"),"hp@test.com", "Password1!"));
        user2 = usersRepository.save(new Users("Ron Weasley","CFO",List.of("Employee"), "rw@test.com", "Password1!"));
        user3 = usersRepository.save(new Users("Hermione Granger","CIO",List.of("Admin"), "hg@test.com", "Password1!"));
        user4 = usersRepository.save(new Users("Fred Weasley","Manager",List.of("Employee"), "fw@test.com", "Password1!"));
        user5 = usersRepository.save(new Users("George Weasley","Manager",List.of("Employee"), "gw@test.com", "Password1!"));
    }
    private void loadCustomers(){
        customer1 = customersRepository.save(new Customers("Richy Phongsavath","rp@test.org",new Address("123 Street","Charlotte","NC","12345")));
        customer2 = customersRepository.save(new Customers("Boy George","bg@test.org",new Address("456 Street","Columbia","SC","67890")));
        customer3 = customersRepository.save(new Customers("Lee Davis","ld@test.org",new Address("123 Street","Charlotte","NC","12345")));
        customer4 = customersRepository.save(new Customers("Steve Stevens","ss@test.org",new Address("1 Drive","Columbia","SC","12392")));
        customer5 = customersRepository.save(new Customers("Tay Tay","tt@test.org",new Address("91 Blvd","Denver","CO","87304")));
        customer6 = customersRepository.save(new Customers("Yeo Thoski","yt@test.org",new Address("5 Block","Denver","CO","89364")));


    }


    private void loadProducts(){
        product1 = productsRepository.save(new Products("10110P","Plant","Knockout Rose","A bush of Knockout Roses", "YMH Gardens",BigDecimal.valueOf(24.99)));
        product2 = productsRepository.save(new Products("94358S","Soil","Readings Top Soil","5 pound bag of organic top soil", "Polar Soil",BigDecimal.valueOf(125.00)));
        product3 = productsRepository.save(new Products("53213D","Beverage","Sir Plant","12 oz Soda", "Drink Up",BigDecimal.valueOf(5.00)));
    }
    private void loadItems() {
        item1 = itemsRepository.save(new Items(product1.getId(), 1, order1));
        item2 = itemsRepository.save(new Items(product2.getId(), 2, order2));
        item3 = itemsRepository.save(new Items(product3.getId(), 3, order3));
        item4 = itemsRepository.save(new Items(product1.getId(), 4, order4));
    }
    private void loadOrders(){
        order1 = ordersRepository.save(new Orders(
                customer1.getId(),
                Date.from(LocalDate.parse("2023-02-20").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(100.00)));
        order2 = ordersRepository.save(new Orders(
                customer2.getId(),
                Date.from(LocalDate.parse("2012-02-20").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(10.00)));
        order3 = ordersRepository.save(new Orders(
                customer2.getId(),
                Date.from(LocalDate.parse("2012-02-20").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(250.00)));
        order4 = ordersRepository.save(new Orders(
                customer2.getId(),
                Date.from(LocalDate.parse("2018-07-27").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(250.00)));
        order5 = ordersRepository.save(new Orders(
                customer2.getId(),
                Date.from(LocalDate.parse("2020-05-23").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(250.00)));
        order6 = ordersRepository.save(new Orders(
                customer2.getId(),
                Date.from(LocalDate.parse("1990-02-28").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(250.00)));
        order7 = ordersRepository.save(new Orders(
                customer2.getId(),
                Date.from(LocalDate.parse("2019-09-10").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(250.00)));
        order8 = ordersRepository.save(new Orders(
                customer2.getId(),
                Date.from(LocalDate.parse("2020-12-20").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(250.00)));
        order9 = ordersRepository.save(new Orders(
                customer2.getId(),
                Date.from(LocalDate.parse("2003-09-20").atStartOfDay(ZoneId.systemDefault()).toInstant()),
                BigDecimal.valueOf(250.00)));
    }


}