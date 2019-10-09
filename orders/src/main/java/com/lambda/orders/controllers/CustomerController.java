package com.lambda.orders.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController
{

  // return all customers and their orders
  // GET - http://localhost:2019/customer/order
  @GetMapping(value = "/order",
              produces = {"application/json"})
  public ResponseEntity<?> listAllCustomers()
  {
    return new ResponseEntity<>(data, HttpStatus.OK);
  }

  // add a new customer including any new orders
  // POST - http://localhost:2019/customer/new
  @PostMapping(value = "/new",
               consumes = {"application/json"})
  public ResponseEntity<?> addNewCustomer(@Valid
                                          @RequestBody Customer customer)
  {
    return new ResponseEntity<>(data, HttpStatus.OK);
  }

  // update the customer based on their custcode
  // PUT - http://localhost:2019/customer/update/{custcode}
  @PutMapping(value = "/update/{custcode}",
              consumes = {"application/json"})
  public ResponseEntity<?> updateCustomer(@RequestBody Customer customer,
                                          @PathVariable long custcode)
  {
    return new ResponseEntity<>(data, HttpStatus.OK);
  }

  // delete the customer based on their custcode
  // DELETE - http://localhost:2019/customer/delete/{custcode}
  @DeleteMapping("/delete/{custcode}")
  public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
  {
    return new ResponseEntity<>(data, HttpStatus.OK);
  }
}
