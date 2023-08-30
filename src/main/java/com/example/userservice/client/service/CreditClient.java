package com.example.userservice.client.service;

import com.example.userservice.client.dto.CreditDto;
import com.example.userservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "order-service", path = "/order-service/credit")
public interface CreditClient {
    @GetMapping(value = "/get-credit-by-user/{id}")
    ResponseDto<Set<CreditDto>> getCreditByUserId(@PathVariable(value = "id") Integer id);
}
