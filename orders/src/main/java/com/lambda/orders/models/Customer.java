package com.lambda.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long custcode;

  @Column(nullable = false)
  private String custname;

  private String custcity;
  private String workingarea;
  private String custcountry;
  private String grade;
  private double openingamt;
  private double receiveamt;
  private double paymentamt;
  private double outstandingamt;
  private String phone;

  @ManyToOne
  @JoinColumn(name = "agentcode",
              nullable = false)
  @JsonIgnoreProperties("customers")
  private Agent agent;

  @OneToMany(mappedBy = "customer",
             cascade = CascadeType.ALL)
  @JsonIgnoreProperties("customer")
  private List<Order> orders = new ArrayList<>();
}
