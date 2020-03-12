package com.lambda.orders.services;

import com.lambda.orders.models.Agent;

import java.util.List;

public interface AgentService
{
  List<Agent> findAll();

  void delete(long id);
}
