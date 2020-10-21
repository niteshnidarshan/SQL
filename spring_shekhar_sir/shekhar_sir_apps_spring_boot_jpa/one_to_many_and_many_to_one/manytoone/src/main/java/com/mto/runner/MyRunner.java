package com.mto.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mto.entity.Customer;
import com.mto.entity.Order;
import com.mto.repository.OrderRepository;

@Component
public class MyRunner implements CommandLineRunner {
	@Autowired
	OrderRepository  orderRepo;

	@Override
	public void run(String... args) throws Exception {
		
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
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		orderRepo.save(order1);
		orderRepo.save(order2);
		*/
		
		//Order  ord = orderRepo.findById(11101).get();
		
		orderRepo.deleteById(11101);
		
	}

}
