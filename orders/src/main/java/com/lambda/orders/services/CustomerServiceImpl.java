package com.lambda.orders.services;

import com.lambda.orders.models.Customer;
import com.lambda.orders.models.Order;
import com.lambda.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
  @Autowired
  private CustomerRepository custrepos;

  @Override
  public List<Customer> findAll()
  {
    List<Customer> rtnList = new ArrayList<>();

    custrepos.findAll().iterator().forEachRemaining(rtnList::add);

    return rtnList;
  }

  @Transactional
  @Override
  public Customer save(Customer customer)
  {
    Customer newCustomer = new Customer();

    newCustomer.setCustname(customer.getCustname());
    newCustomer.setCustcity(customer.getCustcity());
    newCustomer.setWorkingarea(customer.getWorkingarea());
    newCustomer.setCustcountry(customer.getCustcountry());
    newCustomer.setGrade(customer.getGrade());
    newCustomer.setOpeningamt(customer.getOpeningamt());
    newCustomer.setReceiveamt(customer.getReceiveamt());
    newCustomer.setPaymentamt(customer.getPaymentamt());
    newCustomer.setOutstandingamt(customer.getOutstandingamt());
    newCustomer.setPhone(customer.getPhone());

    for (Order o : customer.getOrders())
    {
      newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), newCustomer, o.getOrddescription()));
    }

    return custrepos.save(newCustomer);
  }

  @Override
  public Customer update(Customer customer, long id)
  {
    return custrepos.save(customer);
  }

  @Override
  public void delete(long id)
  {
    custrepos.deleteById(id);
  }
}
