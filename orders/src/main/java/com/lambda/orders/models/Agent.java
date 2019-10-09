package com.lambda.orders.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agent
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long agentcode;

  private String agentname;
  private String workingarea;
  private double commission;
  private String phone;
  private String country;

}
