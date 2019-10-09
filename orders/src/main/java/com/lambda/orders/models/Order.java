package com.lambda.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long ordnum;

  private double ordamount;
  private double advanceamount;
  private String orddescription;

  @ManyToOne
  @JoinColumn(name = "custcode",
              nullable = false)
  @JsonIgnoreProperties("orders")
  private Customer customer;
}
