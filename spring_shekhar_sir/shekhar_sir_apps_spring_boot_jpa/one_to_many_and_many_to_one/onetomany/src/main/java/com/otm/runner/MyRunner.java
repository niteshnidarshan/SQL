package com.otm.runner;

import java.time.LocalDate;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.otm.entity.Customer;
import com.otm.entity.Order;
import com.otm.repository.CustomerRepository;

@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	CustomerRepository  custRepo;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*
		 * The below code is to save customer with associated collection of orders
		 */
		/*
		Customer  customer=new  Customer();
		customer.setCustId(101);
		customer.setCustName("A");
		
		Order  order1 =new Order();
		order1.setId(11101);
		order1.setItemName("Laptop");
		LocalDate  orderDate =LocalDate.of(2020, 10, 10);
		order1.setOrderDate(orderDate);
		
		Order  order2=new  Order();
		order2.setId(29018);
		order2.setItemName("Bag");
		order2.setOrderDate(LocalDate.of(2020, 10, 8));
		
		Set<Order> orders=new HashSet<>();
		orders.add(order1);
		orders.add(order2);
		customer.setOrders(orders);
		
		custRepo.save(customer);
		*/
		
		/*
		 * The below code is to fetch a customer with associated collection of orders
		 */
		//Customer  cust = custRepo.findById(101).get();
		
		/*
		 * The below code is to add a new order to the collection of orders of a customer
		 */
		/*
		Order  new_order=new  Order();
		new_order.setId(39976);
		new_order.setItemName("Keyboard");
		new_order.setOrderDate(LocalDate.of(2020, 10, 12));
		Customer  cust=custRepo.findById(101).get();
		Set<Order>  orders = cust.getOrders();
		orders.add(new_order);
		*/
		
		/*
		 * The below code is to delete a customer
		 */
		custRepo.deleteById(101);
		
		

	}

}
